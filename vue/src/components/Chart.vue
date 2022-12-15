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
          // min: 1,
          // max: "",
          type: "datetime",
          min: new Date("16 nov 2022").getTime(),
          max: new Date("16 dec 2022").getTime(),
          tickAmount: 5,
          title: { text: "" },
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

        tooltip: {
          x: {
            format: "dd MMM yyyy HH mm ss",
          },
        },
      },
      series: [
        {
          name: "Blood-Sugar Log",
          data: [],
        },
      ],
    };
  },
  methods: {
    updateChart(response) {
      response = this.series[0].data;
      const newData = this.series[0].data;
      console.log(this.series[0].data);
      console.log(this.series[0].data.length);
      this.series[0].data = response;
      for (var i = 0; i < newData.length; i++) {
        this.series[0].data = response.data[i];
      }
      console.log(this.newData);
    },
  },
  created() {
    HistoryService.getUserBloodSugarOneMonth()
      .then((response) => {
        console.log(response.data);
        console.log(response.data.length);
        this.options.annotations.yaxis[0].y = response.data[0].targetLow;
        this.options.annotations.yaxis[0].y2 = response.data[0].targetHigh;
        this.options.xaxis.max = response.data.length;
        for (var i = 0; i < response.data.length; i++) {
          response.data[i].lastMeasurement = new Date(
            response.data[i].lastMeasurement
          );

          var x = response.data[i].lastMeasurement.getTime();
          var y = response.data[i].inputLevel;
          console.log(x);

          this.series[0].data.push([x, y]);
          this.newData = response.data;
        }

        console.log(response.data + "this is newData");
        this.updateChart();
        this.series[0].data = response;
        console.log(response);
      })

      .catch((error) => console.error(error));
  },
};
</script>
<style></style>
