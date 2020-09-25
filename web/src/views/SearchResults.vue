<template>
  <div class="search-results">
      <lb-slim-header/>
      <lb-side-bar/>
  </div>
</template>

<script>
import LbSlimHeader from '@/components/LbSlimHeader.vue'
import LbSideBar from '@/components/LbSideBar.vue'

export default {
  name: 'SearchResults',
  components: {
    LbSlimHeader,
    LbSideBar
  }
}
</script>

<style>
.search-results {
  height: calc(100vh - 4rem);
}

body {
  background-color: #E5E5E5;
  background-image: none;
}
</style>
