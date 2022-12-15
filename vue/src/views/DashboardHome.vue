<template>
<div>
  <div id="container">
      <DashboardHome />
  </div>
  <div class="chart-wrapper">

  </div>
  <div class="table-container">
    <Carbs />
  </div>


</div>
</template>

<script>
import DashboardHome from "../components/DashboardHome";

import Carbs from "../components/Carbs"
export default {
  components: {
    DashboardHome,

    Carbs
  },
};
</script>

<style>
.container {  display: grid;
  grid-template-columns: 0.5fr 1fr 1fr;
  grid-template-rows: 1fr 1fr 1fr;
  gap: 0px 0px;
  grid-auto-flow: row;
  grid-template-areas:
    "left-side main-container chart-wrapper"
    "left-side main-container chart-wrapper"
    "left-side main-container table-container";
}
.left-side { grid-area: left-side; }

.main-container { grid-area: main-container; }

.chart-wrapper { grid-area: chart-wrapper; }

.table-container { grid-area: table-container; }
</style>
