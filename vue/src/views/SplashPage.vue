<template>
<div>
    <Header />
    <AboutUs />
    <Footer />
</div>
</template>
    
<script>
import Header from '../components/Header.vue'
import AboutUs from '../components/AboutUs.vue'
import Footer from '../components/Footer.vue'
export default {
    components: {
        Header,
        AboutUs,
        Footer
    }

}
</script>
    
<style>
* {
    box-sizing: border-box;
}

body {
    font-family: 'Open Sans', sans-serif;
}

</style>