<template>
<div>
    <Header />
    
</div>
</template>

<script>
import Header from '../components/Header.vue'
export default {
    components: {
        Header
    }

}
</script>

<style>
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