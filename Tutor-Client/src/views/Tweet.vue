<template>
<div class="main">
    <div class="title">支教推文</div>
    <Cards class = "frist-card"  v-bind:inPage=getBid @getBid='getThis' ></Cards>
</div>

</template>

<script>
import Cards from '@/components/Cards.vue';
export default {
    name: 'tweet',
    data(){
        return{
            getBid: 0,
        }
    },
    components:{
        Cards
    },
    methods:{
        getThis(bid){
            if(bid!=0){
                this.$router.push('/article/'+bid);
            }
        },
    }
}
</script>

<style scoped>

.main {
  background: #34495e url(https://static.pexels.com/photos/36487/above-adventure-aerial-air-large.jpg) no-repeat center / cover fixed;
  z-index: 0;
  height: 1000px;
  position: abosolute;
} 
.title{
    justify-content: center;
    color: white;
    text-align: center;
    font-size: 2rem;
    padding-bottom: 1rem;
    padding-top: 1rem;
}
</style>