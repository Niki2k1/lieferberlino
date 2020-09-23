<template>
  <div class="header">
    <img class="logo" src="/img/Logo.svg">
    <div class="form">
      <h1>Finde Restaurants in deiner Nähe!</h1>
      <input type="text">
      <button>Suchen</button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'LbHeader'
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
  margin: 1rem;
}

.form {
  display: flex;
  flex-direction: column;
  color: white;
  justify-content: center;
  width: 20vw;
  margin: auto;
}
</style>
