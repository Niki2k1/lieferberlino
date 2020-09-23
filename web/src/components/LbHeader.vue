<template>
  <div class="header">
    <div class="logo">
      <img src="/img/Logo.svg">
      <h1>Lieferberlino</h1>
    </div>
    <div class="form">
      <h1>Finde Restaurants in deiner Nähe!</h1>
      <div class="addressBar">
        <input type="text" placeholder="Address">
        <button>Suchen</button>
      </div>
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
  width: 20vw;
  margin: auto;
}

.addressBar {
  display: flex;
  flex-direction: row;
  width: 100%;
}
</style>
