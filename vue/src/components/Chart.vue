<template>
  <div class="chart-wrapper">
 <div class="toolbar">
          <button id="One-Day"
              @click="updateData('One-Day')" :class="{active: selection==='One-Day'}"
              >
            1 Day
          </button>
          
          <button id="Three-Days"
              @click="updateData('Three-Days')" :class="{active: selection==='Three-Days'}"
              >
            3 Days
          </button>
          
          <button id="One-Week"
              
              @click="updateData('One-Week')" :class="{active: selection==='One-Week'}"
              >
            1 Week
          </button>
          
          <button id="Two-Weeks"
              @click="updateData('Two-Weeks')" :class="{active: selection==='Two-Weeks'}"
              >
            2 Weeks
          </button>

           <button id="One-Month"
              @click="updateData('One-Month')" :class="{active: selection==='One-Month'}"
              >
            1 Month
          </button>
          
        </div>
   <apexchart
     width="500" type="line" 
     :options="options" :series="series">
   </apexchart>  
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data: () => ({
    options: {
      chart: {
        id: 'vuechart'
      },
      xaxis: {
      },
      yaxis: {
          min: 30,
          max: 300,
          tickAmount:9,
          title: {
            text: "Blood Sugar"
          },         
      }
    },
    series: [{
      name: 'series-1',
      data: [55, 62, 89, 66, 98, 72, 101, 75, 94, 120, 117, 139]
    },
    {
      name: 'series-2',
      data: [30, 101, 58]
          },],
  })
}
</script>

<style>

</style>