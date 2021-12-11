<template>

  <div class="information">
    <h1>
      ¡Bienvenido
      <span>{{ usuario }}</span
      >!
    </h1>

    
      <h2>
        Puedes pedir tus viajes seguros con nosotros.
      </h2>

    <button v-on:click="loadViaje()"> Pedir Viaje </button>
  </div>
  
</template>


<script>
import gql from "graphql-tag";
import jwt_decode from "jwt-decode";

export default {
  name: "Home",

  data: function () {
    return {
      userId: jwt_decode(localStorage.getItem("token_refresh")).user_id,
      usuario: localStorage.getItem("username"),
      userDetailById: {
        username: "",
        name: "",
        email: "",
      },
    };
  },
  


  apollo: {

  },
 methods: {
      loadViaje: function(){
      this.$router.push({ name: "viaje" });
    },
},
};
</script>


<style>

.information {
  margin: 0;
  padding: 0%;
  width: 100%;
  height: 100%;

  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.information h1 {
  font-size: 60px;
  color: #283747;
}

.information h2 {
  font-size: 40px;
  color: #283747;
  text-align: center;
}

.information span {
  color: rgb(60, 173, 107);
  font-weight: bold;
}
.information button {
  
  height: 40px;

  color: #e5e7e9;
  background: #31573a;
  border: 1px solid #e5e7e9;

  border-radius: 5px;
  padding: 10px 25px;
  margin: 5px 0;
}

.information button:hover {
  
  height: 40px;

  color: #b3d3c3;
  background: #617966;
  border: 1px solid #203b57;

  border-radius: 5px;
  padding: 10px 25px;
  margin: 5px 0;
}
.details h3 {
  font-size: 35px;
  color: #284730;
  text-align: center;
}

.details h2 {
  font-size: 35px;
  color: #283747;
}
.details {
  border: 3px solid rgba(0, 0, 0, 0.3);
  border-radius: 20px;
  padding: 30px 80px;
  margin: 30px 0 0 0;
}

</style>
