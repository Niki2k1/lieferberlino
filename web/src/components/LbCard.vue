<template>
  <div class="card">
      <img src="https://via.placeholder.com/100 " :alt="`${name}_logo`"/>
      <div class="infos">
        <h1>{{ name }} <b-badge class="badge" pill variant="success">Open</b-badge></h1>
        <h2>{{ address }}</h2>
        <h2>{{ address2 }}</h2>
      </div>
  </div>
</template>

<script>
export default {
  props: [
    'name',
    'address',
    'address2'
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
</style>
