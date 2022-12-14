<template>
  <div>
      <h1>Hi</h1>
     <img id="profileImage" ref="profileImage" v-if="profilePic" v-bind:src="profileImage" alt=""> 
  </div>
</template>

<script>
import ProfileService from "../services/ProfileService.js"

export default {
    data() {
        return {
            profilePic: ""
        };
    },

    methods: {
        htmlDecode(input) {
            var doc = new DOMParser().parseFromString(input, "text/html");
            return doc.documentElement.textContent;
},

        decode(str) {

let txt = document.createElement("textarea");

txt.innerHTML = str;

return txt.value;

}
    },



    created() { 
        ProfileService.getUserData()
        .then((response) => {
          this.profilePic = response.data.profilePic;
        })
        .catch((error) => console.error(error));
    },

    computed: {
        profileImage() {
            /*return `data:image/jpeg;base64,${this.profilePic}` */
            let s = atob(this.profilePic)
            console.log(s)
            let decoded = decodeURI(s)
            console.log(decoded)
            return decoded
        }
    }

}
</script>

<style>

</style>