<template>
  <div>
    <div id="container">
      <DashboardHome />
      <Chart />
      <Carbs />
    </div>
  </div>
</template>

<script>
import Chart from "../components/Chart.vue";
import DashboardHome from "../components/DashboardHome";
import Carbs from "../components/Carbs.vue";

export default {
  components: {
    DashboardHome,
    Carbs,
    Chart,
  },
};
</script>

<style>
.container {
  display: grid;
  grid-template-columns: 0.5fr 1fr 1fr;
  grid-template-rows: 1fr 1fr 1fr;
  gap: 0px 0px;
  grid-auto-flow: row;
  grid-template-areas:
    "left-side main-container chart-wrapper"
    "left-side main-container chart-wrapper"
    "left-side main-container table-container";
}

.left-side {
  grid-area: left-side;
  background: white;
}

.main-container {
  grid-area: main-container;
}

.chart-wrapper {
  grid-area: chart-wrapper;
  background: white;
  display: grid;
  grid-template-rows: 1fr 1fr;
  grid-template-areas:
    "chart"
    "Meals";
}

.table-container {
  grid-area: table-container;
}

.user-name {
  color: white;
}
</style>
