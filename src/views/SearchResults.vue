<template>
  <div class="search-results">
      <lb-slim-header/>
      <div class="frame">
        <lb-side-bar v-on:rangeChange="rangeChange" v-on:typeChange="typeChange"/>
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
            :shop="shop"
          />
        </div>
      </div>
  </div>
</template>

<script>
import LbSlimHeader from '@/components/LbSlimHeader.vue'
import LbSideBar from '@/components/LbSideBar.vue'
import LbCard from '@/components/LbCard.vue'
import { getDistance } from 'geolib'

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
      range: Infinity,
      type: 'pickup'
    }
  },
  mounted () {
    if (this.shopList.length === 0) {
      this.$store.dispatch('getShops')
    }

    if (this.$store.state.location.coords.latitude === 0) {
      this.$store.dispatch('getCurrentLocation')
    }
  },
  methods: {
    rangeChange (range) {
      this.range = range * 1000
    },
    typeChange (type) {
      this.type = type
    }
  },
  computed: {
    filteredList () {
      const list = this.shopList.filter(shop => {
        if (shop.delivery && this.type === 'delivery') {
          return false
        } else if (shop.self_pickup && this.type === 'pickup') {
          return false
        }

        const location = {
          latitude: parseFloat(shop.location.split(';')[0]),
          longitude: parseFloat(shop.location.split(';')[1])
        }

        const currentCoords = {
          latitude: this.$store.state.location.coords.latitude,
          longitude: this.$store.state.location.coords.longitude
        }

        const distance = getDistance(
          currentCoords,
          location
        )

        shop.distance = distance

        if (distance > this.range) {
          return false
        } else if (distance === 0) {
          return false
        }
        return true
      })

      list.sort((shop, shop2) => shop.distance - shop2.distance)

      return list
    },
    pagedList () {
      return this.filteredList.slice((this.currentPage - 1) * this.perPage, ((this.currentPage - 1) * this.perPage) + this.perPage)
    },
    rows () {
      return this.filteredList.length
    },
    shopList () {
      return this.$store.state.shopList
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
