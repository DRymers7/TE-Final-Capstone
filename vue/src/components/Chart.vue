<template>
  <div class="chart-wrapper">
    <div v-if="!isLoading">
      <apexchart
        ref=""
        width="500"
        type="line"
        :options="options"
        :series="series"
      >
      </apexchart>
    </div>
  </div>
</template>
<script>
import HistoryService from "../services/HistoryService";
export default {
  data() {
    return {
      isLoading: false,
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
            format: "MMM dd yyyy HH mm ss",
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

    resizeWindow() {
      /**
       * use this event beacuse apexchart has an issue that when chart disappear because there is no data
       * chart will not appear again if we get new data until you resize the browser
       */
      window.dispatchEvent(new Event("resize"));
    },
  },

  // getUserBloodSugarOneDay(){
  //   HistoryService.getUserBloodSugarOneDay()
  // },

  // getUserBloodSugar

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
        this.isLoading = false;
        console.log(response);
      })

      .catch((error) => console.error(error));
  },

  mounted() {
    this.resizeWindow();
  },
};
</script>
<style></style>
