<template>
  <div class="card">
      <img :src="shop.image || 'https://via.placeholder.com/100'" :alt="`${shop.name}_logo`"/>
      <div class="infos">
        <h1>{{ shop.name }} <b-badge class="badge" pill :variant="shop.isOpen ? 'success' : 'danger'">{{ shop.isOpen ? 'Geöffnet' : 'Geschlossen' }}</b-badge></h1>
        <h2>{{ shop.type }}</h2>
        <h2>{{ shop.street }}</h2>
        <h2>{{ shop.postalcode }} Ort</h2>
      </div>
      <router-link :to="{ name: 'details', params: { id: shop.id }}" class="button">
        <b-icon icon="arrow-right"/>
      </router-link>
  </div>
</template>

<script>
export default {
  props: [
    'shop'
  ]
}
</script>

<style scoped>
.card {
  display: flex;
  flex-direction: row;
  border: solid 1px #C4C4C4C4;
  border-radius: .5rem;
  background-color: #F5F5F5;
  color: #333333;
  margin: 1.5rem 1.5rem 0 1.5rem;
  padding: 1rem;
  height: max-content;
}

.card:first-of-type {
  margin-top: 0;
}

.card img {
  border-radius: .5rem;
  object-fit: contain;
  width: 100px;
  height: 100px;
  padding: .5rem;
  background-color: #cccccc;
}

.card .infos {
  margin-left: 1rem;
}

.card .infos h1 {
  line-height: .7;
  font-size: 1.75rem;
  display: flex;
}

.card .infos h1 .badge {
  font-size: .75rem;
  margin: auto 0 auto .5rem;
}

.card .infos h2 {
  line-height: .7;
  font-size: 1rem;
}

.button {
  display: flex;
  border-radius: 100%;
  background-color: #848484;
  color: white;
  width: 4rem;
  height: 4rem;
  margin: auto 0 auto auto;
  font-size: 2rem;
}

.button * {
  margin: auto;
}
</style>
