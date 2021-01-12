<template>
  <div class="details">
      <div class="info">
        <img :src="shop.image || 'https://via.placeholder.com/200'" :alt="`${shop.name}_logo`"/>
        <ul>
          <li><h2>{{ shop.name }} <b-badge class="badge" pill :variant="shop.isOpen ? 'success' : 'danger'">{{ shop.isOpen ? 'Geöffnet' : 'Geschlossen' }}</b-badge></h2></li>
          <li>{{ shop.street || 'Straße nicht verfügbar' }}</li>
          <li>{{ shop.postalcode || 'PLZ nicht verfügbar' }}</li>
          <li><a :href="shop.website" target="_blank">{{ shop.website || 'Keine Website vorhanden' }}</a></li>
          <li><a :href="`mailto:${shop.mail}`">{{ shop.mail || 'Keine E-Mail vorhanden' }}</a></li>
          <li>{{ shop.fon }}</li>
        </ul>
        <ul class="opening-hours">
          <li><span class="weekday">Montag: </span>{{ shop.monday || 'Geschlossen' }}</li>
          <li><span class="weekday">Dienstag: </span>{{ shop.tuesday || 'Geschlossen' }}</li>
          <li><span class="weekday">Mittwoch: </span>{{ shop.wednesday || 'Geschlossen' }}</li>
          <li><span class="weekday">Donnerstag: </span>{{ shop.thursday || 'Geschlossen' }}</li>
          <li><span class="weekday">Freitag: </span>{{ shop.friday || 'Geschlossen' }}</li>
          <li><span class="weekday">Samstag: </span>{{ shop.saturday || 'Geschlossen' }}</li>
          <li><span class="weekday">Sonntag: </span>{{ shop.sunday || 'Geschlossen' }}</li>
        </ul>
      </div>
      <div class="shipping-info">
        <div class="shipping">
          <h3>Lieferung</h3>
          <div class="card">
            <div class="icon">
              <img :src="getIcon(shop.delivery)">
            </div>
            <h5>
              {{ shop.description_delivery || 'Keine Information' }}
            </h5>
          </div>
        </div>
        <div class="collect">
          <h3>Abholung</h3>
          <div class="card">
            <div class="icon">
              <img :src="getIcon(shop.self_pickup)">
            </div>
            <h5>
              {{ shop.description_self_pickup }}
            </h5>
          </div>
        </div>
      </div>
  </div>
</template>
<script>
export default {
  props: [
    'shop'
  ],
  methods: {
    getIcon (value) {
      if (value) {
        return '/img/check-mark-icon.png'
      } else {
        return '/img/cross-icon.png'
      }
    }
  }
}
</script>

<style scoped>
.details {
  display: flex;
  flex-direction: column;
  padding: 5rem;
  width: 100vw;
}

.info {
  display: flex;
  flex-direction: row;
}

.info img {
  border-radius: 15px;
  object-fit: contain;
  width: 200px;
  height: 200px;
  padding: .5rem;
  background-color: #cccccc;
}

.info ul {
  list-style: none;
}

.shipping-info {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin-top: 1rem;
  text-align: center;
}

.card {
  border-radius: 15px;
  border: #C4C4C4 1px solid;
  background-color: #F5F5F5;
  padding: 2.5rem;
  width: 40vw;
  text-align: center;
  display: flex;
  flex-direction: row;
}

.card h5 {
  text-align: center;
  margin: auto;
}

.card .icon {
  border-radius: 15px;
  background-color: #E0E0E0;
  border: #C4C4C4 1px solid;
  padding: 2rem;
  display: flex;
}

.card .icon img {
  width: 3rem;
  height: 3rem;
  margin: auto;
}

.opening-hours {
  margin-left: auto;
  display: flex;
  flex-direction: column;
}

.opening-hours li {
  display: flex;
}

.opening-hours .weekday {
  width: 7rem;
  font-weight: 700;
}

@media only screen and (max-width: 64em) {
  .details {
    padding: 1rem;
  }

  .info img {
    width: 200px;
    height: 200px;
    margin: auto;
  }

  .info ul {
    padding: 0;
    margin: 2rem 0;
  }

  .card {
    flex-flow: column;
    width: 100%;
  }

  .icon {
    width: 5rem;
    height: 5rem;
    margin: auto;
    padding: 0 !important;
    display: flex;
    flex-flow: column;
  }

  .icon img {
    margin: auto;
  }

  .card h5 {
    margin-top: 1rem;
  }

  .collect {
    margin-top: 2rem;
  }

  .shipping-info {
    flex-flow: column;
  }
}
</style>
