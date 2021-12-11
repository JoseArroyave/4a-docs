<template>

  <div id="Transaction" class="transaction">
    <div class="container_transaction">
      <h2>Solicitar conductor</h2>

      <form v-on:submit.prevent="processViaje">
        <input
          type="text"
          v-model="createViaje.direccionOrigen"
          placeholder="Direccion origen"
        />
        <br />
        <input
          type="text"
          v-model="createViaje.direccionDestino"
          placeholder="Dirección destino"
        />
        <br />

        <button type="submit">Solicitar</button>
      </form>
    </div>
  </div>

</template>


<script>
import gql from "graphql-tag";

export default {
  name: "Viaje",

  data: function() {
    return {
      min:5000,
      max:15000,
      getElegido: {           
            cedula:"",
            nombres:"",
            apellidos:"",
            telefono:"",
            tipoCarro:"",
            
      },
      elegido: "",
      preciocalc:0,
      createViaje: {
        
        cliente: localStorage.getItem("username"),
        conductor: "",
        esAmigo: false,
        direccionOrigen:"",
        direccionDestino:"",
        precio: Math.round(Math.random() * (15000 - 5000) + 5000),
        activo: true
      },
    };
  },
  apollo: {
    getElegido: {
      query: gql`
        query GetElegido {
          getElegido {
            cedula
            nombres
            apellidos
            telefono
            tipoCarro
          }
        }
      `,
    
    },},

  methods: {
    procesarPrecioyConductor: function (){
      this.elegido = this.getElegido.cedula;
      
      this.preciocalc = Math.random() * (15000 - 5000) + 5000;
      
    },
    processViaje: async function() {
      
      if (localStorage.getItem("token_access")  === null ||
          localStorage.getItem("token_refresh") === null ) {
        this.$emit("logOut");
        return;
      }

      localStorage.setItem("token_access", "");

      await this.$apollo
        .mutate({
          mutation: gql`
            mutation ($refresh: String!) {
              refreshToken(refresh: $refresh) {
                access
              }
            }
          `,
          variables: {
            refresh: localStorage.getItem("token_refresh"),
          },
        })
        .then((result) => {
          localStorage.setItem("token_access", result.data.refreshToken.access);
        })
        .catch((error) => {
          this.$emit("logOut");
          return;
        });
      
      
      this.preciocalc = Math.round(Math.random() * (15000 - 5000) + 5000);
      this.createViaje.conductor = this.getElegido.cedula;
      await this.$apollo
        
        .mutate({
          mutation: gql`
            mutation CreateViaje($viaje: ViajeInput!) {
              createViaje(viaje: $viaje) {
                
                conductor
                cliente
                esAmigo
                direccionOrigen
                direccionDestino
                precio
                fechaViaje
                activo
              }
            }
          `,
          variables: {
            viaje: this.createViaje,
          },
        })
        .then((result) => {
          alert(`El conductor ${this.getElegido.nombres}, te recogerá en el carro ${this.getElegido.tipoCarro}, el viaje costará $${this.createViaje.precio}.`);
          this.$router.push({ name: "perfil" });
        })
        .catch((error) => {
          alert("Algo salió mál");
        });
    },
  },
  created: function () {
    this.$apollo.queries.getElegido.refetch();
    
    this.procesarPrecioyConductor();
    console.log(this.getElegido)
  }
};
</script>


<style>

.transaction {
  margin: 0;
  padding: 0%;
  height: 100%;
  width: 100%;

  display: flex;
  justify-content: center;
  align-items: center;
}

.container_transaction {
  border: 3px solid #1b743d;
  border-radius: 10px;
  width: 25%;
  height: 60%;

  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.transaction h2 {
  color: #063331;
}

.transaction form {
  width: 50%;
}

.transaction input {
  height: 40px;
  width: 100%;

  box-sizing: border-box;
  padding: 10px 20px;
  margin: 5px 0;

  border: 1px solid #173f36;
}

.transaction button {
  width: 100%;
  height: 40px;

  color: #e5e7e9;
  background: #31573a;
  border: 1px solid #e5e7e9;

  border-radius: 5px;
  padding: 10px 25px;
  margin: 5px 0;
}

.transaction button:hover {
  color: #e5e7e9;
  background: rgb(42, 44, 41);
  border: 1px solid #283747;
}

</style>
