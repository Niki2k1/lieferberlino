<template>
  <div class="sidebar">
      <div class="filter">
        <h2>Bestellung</h2>
        <div class="button-group">
          <button id="pickup" :class="`filter-button ${isDelivery ? '' : 'active'}`" @click="changeType">Abholung</button>
          <button id="delivery" :class="`filter-button ${isDelivery ? 'active' : ''}`" @click="changeType">Lieferung</button>
        </div>
        <div class="radius">
          <h3>Radius</h3>
          <h3 id="range-label">{{ range }}km</h3>
        </div>
        <input type="range" min="1" max="20" v-model="range" @input="changed" class="slider" id="range-slider">
      </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      isDelivery: false,
      range: 15
    }
  },
  methods: {
    changeType (event) {
      if (event.target.id === 'delivery') {
        this.isDelivery = true
      } else {
        this.isDelivery = false
      }
      this.$emit('typeChange', event.target.id)
    },
    changed () {
      this.$emit('rangeChange', this.range)
    }
  }
}
</script>

<style scoped>
.sidebar {
  height: 100%;
  width: 25rem;
  background-color: #333333;
  color: white;
}

.filter {
  display: flex;
  flex-direction: column;
  padding: 1rem;
}

.filter h2,h3 {
  margin: .5rem;
}

.radius {
  display: flex;
  flex-direction: row;
  margin-top: 1rem;
}

#range-label {
  margin-left: auto;
}

.button-group {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.filter-button {
  border: #ffffff 2px solid;
  background-color: transparent;
  color: #ffffff;
  padding: .5rem 1.5rem .5rem 1.5rem;
  font-family: 'Roboto';
  font-weight: 300;
  margin: 0 .5rem 0 .5rem;
}

.filter-button.active {
  border: #2ECC71 2px solid;
  color: #2ECC71;
}

.slider {
  -webkit-appearance: none;
  height: 5px;
  border-radius: 15px;
  background: white;
  outline: none;
  -webkit-transition: opacity .15s ease-in-out;
  transition: opacity .15s ease-in-out;
  overflow: visible;
  margin: .5rem;
}

.slider::-webkit-slider-thumb {
  -webkit-appearance: none;
  appearance: none;
  width: 20px;
  height: 20px;
  border-radius: 50%;
  background: #2ECC71;
  cursor: pointer;
}

.slider::-moz-range-thumb {
  width: 20px;
  height: 20px;
  background: #2ECC71;
  border-radius: 50%;
  cursor: pointer;
}
</style>
