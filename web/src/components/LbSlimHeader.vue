<template>
  <div class="slimheader">
    <div class="logo">
      <img src="../assets/Logo.svg">
      <h1>Lieferberlino</h1>
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
.slimheader {
  display: flex;
  width: 100vw;
  height: 4rem;
  background-color: #444444;
}

.logo {
  display: flex;
  flex-direction: row;
  width: fit-content;
  margin: 0;
}

.logo img {
  width: 110px;
}

.logo h1 {
  margin: auto;
  color: white;
  font-weight: 300;
  font-size: 2rem;
}
</style>
