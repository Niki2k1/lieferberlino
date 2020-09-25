<template>
  <div class="sidebar">
      <div class="filter">
        <h2>Bestellung</h2>
        <div class="button-group">
          <button class="filter-button active">Abholung</button>
          <button class="filter-button">Lieferung</button>
        </div>
      </div>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
.sidebar {
  height: 100%;
  width: 20rem;
  background-color: #333333;
  color: white;
}

.filter {
  display: flex;
  flex-direction: column;
}

.filter h2{
  margin: 1rem auto 1rem 1rem;
}

.button-group {
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
}

.filter-button {
  border: #ffffff 2px solid;
  background-color: transparent;
  color: #ffffff;
  padding: .5rem 1.5rem .5rem 1.5rem;
  font-family: 'Roboto';
  font-weight: 300;
}

.filter-button.active {
  border: #2ECC71 2px solid;
  color: #2ECC71;
}
</style>
