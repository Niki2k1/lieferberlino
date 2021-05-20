<template>
  <div id="home">
    <lb-header/>
  </div>
</template>

<script>
import LbHeader from '@/components/LbHeader.vue'

export default {
  name: 'Home',
  components: {
    LbHeader
  }
}
</script>

<style scoped>
#home {
  background-image: url('../assets/pexels-pixabay-280453.jpg');
  background-repeat: no-repeat;
  background-size: 100%;
}
</style>
