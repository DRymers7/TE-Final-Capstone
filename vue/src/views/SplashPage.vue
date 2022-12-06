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
*{
    box-sizing: border-box;
}
html, body{
margin: 0;
padding: 0;
font-family: 'Lato', sans-serif;
color: #1f4568;
}
body{
 background: linear-gradient(120DEG, #dbe9eeff,#35495E);
background-size:cover;
background-repeat:no-repeat;
background-position: center;
}

</style>