<template>
  <div class="search-results">
      <lb-slim-header/>
      <div class="frame">
        <lb-side-bar/>
        <div class="card-list">
          <b-pagination
            class="m-4"
            v-model="currentPage"
            :total-rows="rows"
            :per-page="perPage"
            align="fill"
          />
          <lb-card
            v-for="shop in pagedList"
            :key="shop.id"
            :name="shop.name"
            :address="shop.street"
            :address2="shop.postalcode"
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
  },
  data () {
    return {
      perPage: 20,
      currentPage: 1,
      search: '',
      shopList: []
    }
  },
  mounted () {
    fetch('https://api.lieferberlino.de/shops/getShops').then(async (response) => {
      this.shopList = await response.json()
    })
  },
  computed: {
    filteredList () {
      return this.shopList.filter(shop => {
        return shop.name.toLowerCase().includes(this.search.toLowerCase())
      })
    },
    pagedList () {
      return this.filteredList.slice((this.currentPage - 1) * this.perPage, ((this.currentPage - 1) * this.perPage) + this.perPage)
    },
    rows () {
      return this.filteredList.length
    }
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
  flex-direction: column;
  overflow: scroll;
  height: calc(100vh - 4rem);
  width: -webkit-fill-available;
}

.page-link {
  color: #2ECC71 !important;
}

.page-item.active .page-link {
    color: #fff !important;
    background-color: #2ECC71 !important;
    border-color: #2ECC71 !important;
}
</style>
