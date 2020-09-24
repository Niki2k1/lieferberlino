<template>
  <div class="header">
    <div class="logo">
      <img src="/img/Logo.svg">
      <h1>Lieferberlino</h1>
    </div>
    <div class="form">
      <h1 class="text-shadow">Finde Restaurants in deiner Nähe!</h1>
      <div class="addressBar shadow">
        <input type="text" placeholder="Address" v-model="location">
        <button class="btn btn-primary">Suchen</button>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
  name: 'LbHeader',
  created () {
    this.$store.dispatch('getCurrentLocation')
  },
  computed: mapState({
    location: state => state.location
  })
}
</script>

<style scoped>
.header {
  background-image: url('/img/Header.svg');
  background-size: 100%;
  background-repeat: no-repeat;
  height: 100vh;
}

.logo {
  display: flex;
  flex-direction: row;
  width: fit-content;
}

.logo img {
  margin: 1rem;
}

.logo h1 {
  margin: auto;
  color: white;
}

.form {
  display: flex;
  flex-direction: column;
  color: white;
  justify-content: center;
  width: 25vw;
  margin: auto;
}

.addressBar {
  display: flex;
  flex-direction: row;
  width: 100%;
}

.addressBar input{
  width: -webkit-fill-available;
}

.addressBar button{
  border-radius: 0 .25rem .25rem 0;
}
</style>
