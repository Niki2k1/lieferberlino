<template>
  <div class="details-container">
    <lb-slim-header :showBackLink="true"/>
    <lb-details v-if="shop" :shop="shop"/>
  </div>
</template>

<script>
import LbSlimHeader from '@/components/LbSlimHeader.vue'
import LbDetails from '../components/LBDetails'
import { mapState } from 'vuex'

export default {
  name: 'Details',
  data () {
    return {
      shop: undefined
    }
  },
  components: {
    LbSlimHeader,
    LbDetails
  },
  mounted () {
    if (!this.shop) {
      this.$store.dispatch('getShops')
    }
  },
  computed: mapState({
    shopList: state => state.shopList
  }),
  watch: {
    shopList: function (value) {
      const shop = value.find(shop => shop.id === parseInt(this.$route.params.id))
      this.shop = shop
    }
  }
}
</script>

<style>
body {
  background-color: #E5E5E5;
  background-image: none;
}
</style>
