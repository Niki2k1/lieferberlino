<template>
  <div class="slimheader">
    <a @click="$router.go(-1)" class="backButton" v-if="showBackLink">
      <b-icon icon="arrow-left"/>
    </a>
    <router-link to="/">
      <div class="logo">
        <img src="../assets/Logo.svg">
        <h1>Lieferberlino</h1>
      </div>
    </router-link>
  </div>
</template>

<script>
export default {
  props: [
    'showBackLink'
  ]
}
</script>

<style scoped>
.slimheader {
  display: flex;
  width: 100vw;
  height: 4rem;
  background-color: #444444;
}

.slimheader a {
  display: flex;
}

.slimheader a:hover {
  text-decoration: none;
}

.logo {
  display: flex;
  flex-direction: row;
  width: fit-content;
  margin: 0;
}

.logo img {
  width: 110px;
  height: 3.5rem;
}

.logo h1 {
  margin: auto;
  color: white;
  font-weight: 300;
  font-size: 2rem;
  text-decoration: none;
}

.backButton {
  color: white;
  font-size: 2rem;
  margin: auto 0 auto 1rem;
  cursor: pointer;
}
</style>
