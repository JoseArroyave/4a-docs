<template>
  <div id="Historial">
    <div class="container">
      <h2>
        Mi usuario:
        <span>{{ username }}</span>
      </h2>
    </div>

    <h2>Mis viajes</h2>
    <div class="container-table">
      <table>
        <tr>
          
          <th>Fecha / Hora</th>

          <th>Origen</th>
          <th>Destino</th>
          <th>Valor</th>
          <th>Estado</th>
          <th>Finalizar</th>
        </tr>

        <tr v-for="Viaje in viajesdecliente" :key="Viaje.id">
           
          <td>
            {{ Viaje.fechaViaje.substring(-6, 10) }} /
            {{ Viaje.fechaViaje.substring(11, 19) }}
          </td>

          <td>{{ Viaje.direccionOrigen }}</td>
          <td>{{ Viaje.direccionDestino }}</td>
          <td>${{ Viaje.precio }} COP</td>
          <td v-if="Viaje.activo == true">Viaje Activo</td>
          <td v-else>Viaje terminado</td>
          <td>
            <button
              v-on:click="terminarViaje(Viaje.id)"
              
              style="
                cursor: pointer;
                font-size: 10px;
                padding: 5px 8px;
                border-radius: 50%;
                background: #4db8d5;
              "
            >
              <strong>X</strong>
            </button>
          </td>
        </tr>
      </table>
    </div>
  </div>
</template>


<script>
import gql from "graphql-tag";

export default {
  name: "Perfil",

  data: function () {
    return {
      username: localStorage.getItem("username") || "none",
      getByCliente: [],
      viajesdecliente:[],
      terminarViajeId:"",

    };
  },

  apollo: {
    getByCliente: {
      query: gql`
        query GetByCliente {
          getByCliente {
            id
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
    
    },

  },

  methods: {
    filtrarviajes: function(){
      this.$apollo.queries.getByCliente.refetch();
      this.getByCliente.forEach(element => {
        if (element.cliente == this.username){
          this.viajesdecliente.push(element);
      }}); 
        console.log(this.viajesdecliente)
        
    },
    ponerID:  function(idv){
      console.log(idv);
       this.terminarViaje(idv);
    },
    terminarViaje: async function(iddata){
      
     await this.$apollo
      .mutate({
        mutation: gql`
          mutation TerminarViaje($terminarViajeId: String!) {
            terminarViaje(id: $terminarViajeId) {
              id
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
        terminarViajeId: iddata,
      },
      })
      .then((result) => {
        alert("Viaje terminado correctamente");
        
      
      })
      .catch(() => {
      
      alert("No es posible terminar el viaje.");
      
      });
      },
      },
          
  
  beforeMount() {
    
  },
    beforeCreate() {

  },
  created: function () {
    // this.$apollo.queries.getByCliente.refetch();
    this.filtrarviajes();
    
  }
};
</script>


<style>
#Historial {
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: flex-start;
  align-items: center;
  flex-direction: column;
 
  
}

#Historial .container-table {
  width: 50%;

  max-height: 250px;
  overflow-y: scroll;
  overflow-x: hidden;
 margin-bottom: 50px;
}

#Historial table {
  width: 100%;
  border-collapse: collapse;
  border: 1px solid rgba(0, 0, 0, 0.3);
}

#Historial table td,
#Historial table th {
  border: 1px solid #ddd;
  padding: 8px;
}

#Historial table tr:nth-child(even) {
  background-color: #f2f2f2;
}

#Historial table tr:hover {
  background-color: #ddd;
}

#Historial table th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: rgb(52, 129, 69);
  color: white;
}

#Historial > h2 {
  color: #283747;
  font-size: 25px;
}

#Historial .container {
  padding: 30px;
  border: 3px solid rgba(0, 0, 0, 0.3);
  border-radius: 20px;
  margin: 5% 0 1% 0;
}

#Historial .container h2 {
  font-size: 25px;
  color: #283747;
}
#Historial .container span {
  color: rgb(61, 92, 31);
  font-weight: bold;
}
</style>