<template>
  <div class="chart-wrapper">
    <div class="toolbar">
      <button
        id="One-Day"
        @click="updateData('One-Day')"
        :class="{ active: selection === 'One-Day' }"
      >
        1 Day
      </button>
      <button
        id="Three-Days"
        @click="updateData('Three-Days')"
        :class="{ active: selection === 'Three-Days' }"
      >
        3 Days
      </button>
      <button
        id="One-Week"
        @click="updateData('One-Week')"
        :class="{ active: selection === 'One-Week' }"
      >
        1 Week
      </button>
      <button
        id="Two-Weeks"
        @click="updateData('Two-Weeks')"
        :class="{ active: selection === 'Two-Weeks' }"
      >
        2 Weeks
      </button>
      <button
        id="One-Month"
        @click="updateData('One-Month')"
        :class="{ active: selection === 'One-Month' }"
      >
        1 Month
      </button>
    </div>
    <apexchart
      ref=""
      width="500"
      type="line"
      :options="options"
      :series="series"
    >
    </apexchart>
  </div>
</template>
<script>
import HistoryService from "../services/HistoryService";
export default {
  data() {
    return {
      options: {
        chart: {
          id: "vuechart",
        },
        xaxis: {
          type: "datetime",
          min: "",
          max: "",
          tickAmount: 5,
        },
        yaxis: {
          min: 30,
          max: 300,
          tickAmount: 9,
          title: { text: "Blood Sugar" },
        },
        annotations: {
          yaxis: [
            {
              y: "",
              y2: "",
              borderColor: "#000",
              fillColor: "#FEB019",
              opacity: 0.2,
              label: {
                borderColor: "#333",
                style: {
                  fontSize: "10px",
                  color: "#333",
                  background: "#FEB019",
                },
                text: "Blood Sugar Range",
              },
            },
          ],
        },
      },
      series: [
        {
          name: "series-1",
          data: [],
        },
      ],
    };
  },

  methods: {
    updateChart() {
      const newData = this.series[0].data;

      console.log(newData);
      this.series[0].data = [newData];
      if (isNaN(this.series[0].data)) {
        console.log("not a number found");
        console.log(this.newData);
      }
    },
  },

  created() {
    HistoryService.getUserHistoryOneMonth()
      .then((response) => {
        this.options.annotations.yaxis[0].y = response.data[0].targetLow;
        this.options.annotations.yaxis[0].y2 = response.data[0].targetHigh;
        this.series[0].data = response.data[0].inputLevel;
        this.newData = response.data[0];

        console.log(this.newData.inputLevel);
        this.updateChart();
      })
      .catch((error) => console.error(error));
  },
};
</script>
<style></style>
