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

<style scoped>
.search-results {
  height: calc(100vh - 4rem);
}
</style>
