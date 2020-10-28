<template>
  <div class="search-results">
      <lb-slim-header/>
      <div class="frame">
        <lb-side-bar/>
        <div class="card-list">
          <lb-card
            name="Restaurant name"
            address="Cool Address 12"
            address2="12345 Berlin"
          />
        </div>
      </div>
  </div>
</template>

<script>
import LbSlimHeader from '@/components/LbSlimHeader.vue'
import LbSideBar from '@/components/LbSideBar.vue'
import LbCard from '@/components/LbCard.vue'

export default {
  name: 'SearchResults',
  components: {
    LbSlimHeader,
    LbSideBar,
    LbCard
  }
}
</script>

<style>
body {
  background-color: #E5E5E5;
  background-image: none;
}

.search-results {
  display: flex;
  flex-direction: column;
}

.frame {
  display: flex;
  flex-direction: row;
  height: calc(100vh - 4rem);
}

.card-list {
  display: flex;
  flex-direction: row;
  height: calc(100vh - 4rem);
  width: -webkit-fill-available;
}
</style>
