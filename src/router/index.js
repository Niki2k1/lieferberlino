import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import SearchResults from '../views/SearchResults.vue'
import Details from '../views/Details.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/results',
    name: 'searchResults',
    component: SearchResults
  },
  {
    path: '/details/:id',
    name: 'details',
    component: Details
  }
]

const router = new VueRouter({
  base: process.env.BASE_URL,
  routes
})

export default router
