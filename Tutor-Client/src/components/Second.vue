<template>
  <div class="slider">
  <div class="items-group">
    <div class="item">
      <div class="block">
        <span class="circleLight"></span>
        <div class="text">
          <h2>Hi</h2>
          <p>I`m cool card</p>
        </div>
      </div>
    </div>
    <div class="item">
      <div class="block">
        <span class="circleLight"></span>
        <div class="text">
          <h2>Hi</h2>
          <p>I`m cool card</p>
        </div>
      </div>
    </div>
    <div class="item">
      <div class="block">
        <span class="circleLight"></span>
        <div class="text">
          <h2>Hi</h2>
          <p>I`m cool card</p>
        </div>
      </div>
    </div>
    <div class="item">
      <div class="block">
        <span class="circleLight"></span>
        <div class="text">
          <h2>Hi</h2>
          <p>I`m cool card</p>
        </div>
      </div>
    </div>
  </div>

  <div class="navigations">
    <ul class="dots"></ul>
  </div>
</div>
</template>

<script>
export default {

  data(){
    return {
        mouse : {
            X   : 0,
            Y   : 0,
            CX  : 0,
            CY  : 0
        },
        imags : [
            'https://images.pexels.com/photos/4245826/pexels-photo-4245826.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940',
            'https://images.pexels.com/photos/39811/pexels-photo-39811.jpeg?w=940&h=650&auto=compress&cs=tinysrgb',
            'https://images.pexels.com/photos/210546/pexels-photo-210546.jpeg?w=940&h=650&auto=compress&cs=tinysrgb',
            'https://images.pexels.com/photos/3244513/pexels-photo-3244513.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940',
        ]

    }
  },

  computed:{
    getBlock(){
      var block = { 
        X   : this.mouse.X,
        Y   : this.mouse.Y,
        CX  : this.mouse.CX,
        CY  : this.mouse.CY,
      }
      return block;
    }
  },

  mouted(){

    // $('.block').on('mousemove', function(e) {
    //   this.mouse.X   = (e.pageX - $(this).offset().left) - $('.block').width() / 2;
    //   this.mouse.Y   = (e.pageY - $(this).offset().top) - $('.block').height() / 2;
    // })

    // $('.block').on('mouseleave', function(e) {
    //   this.mouse.X   = this.mouse.CX;
    //   this.mouse.Y   = this.mouse.CY;
    //   e;
    // })

    // setInterval(function(){
    //   this.block().CY   += (this.mouse.Y - this.block.CY) / 12;
    //   this.block.CX   += (this.mouse.X - this.block.CX) / 12;

    //   $('.block .circleLight').css('background', 'radial-gradient(circle at ' + this.mouse.X + 'px ' + this.mouse.Y + 'px, #fff, transparent)')
    //   $('.block').css({
    //     transform : 'scale(1.03) translate(' + (this.block.CX * 0.05) + 'px, ' + (this.block.CY * 0.05) + 'px) rotateX(' + (this.block.CY * 0.05) + 'deg) rotateY(' + (this.block.CX * 0.05) + 'deg)'
    //   })

    // }, 20);

    // $('.slider .item').each(function(i){
      
    //   if(i == 0){
        
    //     $(this).addClass('active');
    //     $(this).next().addClass('next');
    //     $(this).prev().addClass('prev');
    //   }
      
    //   $(this).attr('id', 'slide-'+i);
      
    //   $(this).prepend(
    //     $('<div>', {class: 'blur', style: 'background-image: url(' + this.imags[i] + ');'}),
    //     $('<div>', {class: 'bg', style: 'background-image: url(' + this.imags[i] + ');'})
    //   )
      
    //   $(this).find('.block').css('background-image', 'url(' + this.imags[i] + ')')
      
    //   $('.navigations .dots').append(
    //     $('<li>', {class: i == 0 ? 'active' : '', id: i}).on('click', function(){
    //     var cSlide = $('.slider #slide-'+$(this).attr('id'));
          
    //       $('.navigations .dots li').removeClass('active');
    //       $(this).addClass('active');
          
    //       $('.slider .item').removeClass('active prev next');
    //       cSlide.addClass('active');
    //       cSlide.next().addClass('next');
    //       cSlide.prev().addClass('prev');
    //     })
    //   )
    // })
  }

}
</script>

<style scoped>
.slider {
  width: 100%;
  height: 100vh;
}
.slider .items-group {
  width: 100%;
  height: 100%;
  position: relative;
}
.slider .items-group .item {
  top: 0px;
  left: 0px;
  opacity: 0;
  width: 100%;
  height: 100%;
  display: flex;
  overflow: hidden;
  transition: 0.5s;
  visibility: hidden;
  position: relative;
  padding: 50px 20px;
  position: absolute;
  align-items: center;
  justify-content: center;
  box-sizing: border-box;
}
.slider .items-group .item:hover .bg {
  opacity: 0.2;
}
.slider .items-group .item:hover .block {
  box-shadow: 0px 0px 50px #333;
}
.slider .items-group .item.active {
  opacity: 1;
  visibility: visible;
}
.slider .items-group .item .bg {
  top: 0px;
  left: 0px;
  opacity: 1;
  z-index: -1;
  width: 100%;
  height: 100%;
  transition: 0.5s;
  position: absolute;
  transform: scale(1.03);
  background-size: cover;
  background-position: center;
  background-attachment: fixed;
}
.slider .items-group .item .blur {
  top: 0px;
  left: 0px;
  z-index: -1;
  width: 100%;
  height: 100%;
  transition: 0.5s;
  filter: blur(5px);
  position: absolute;
  transform: scale(1.03);
  background-size: cover;
  background-position: center;
  background-attachment: fixed;
}
.slider .items-group .item .block {
  width: 100%;
  height: 100%;
  padding: 20px;
  color: #ffffff;
  transition: box-shadow 0.5s;
  max-width: 300px;
  overflow: hidden;
  max-height: 450px;
  border-radius: 10px;
  transform: scale(1.03);
  box-sizing: border-box;
  background-size: cover;
  background-position: center;
  background-attachment: fixed;
  box-shadow: none;
}
.slider .items-group .item .block .circleLight {
  top: 0px;
  left: 0px;
  opacity: 0;
  content: "";
  width: 100%;
  height: 100%;
  display: block;
  transition: 0.5s;
  position: absolute;
  border-radius: 10px;
  background: radial-gradient(circle at 80px 40px, #fff, transparent);
}
.slider .items-group .item .block .text {
  width: 100%;
  height: 100%;
  display: flex;
  text-align: center;
  flex-direction: column;
  justify-content: center;
  background-position: center;
  background-attachment: fixed;
}
.slider .items-group .item .block h2 {
  font-family: "Oswald", sans-serif;
  font-size: 130px;
  margin-bottom: 0px;
}
.slider .items-group .item .block p {
  font-family: "Open Sans", sans-serif;
  font-size: 15px;
}
.slider .items-group .item .block:hover {
  box-shadow: 0px 0px 70px #111;
}
.slider .items-group .item .block:hover .circleLight {
  opacity: 0.4;
}
.slider .navigations {
  bottom: 0px;
  width: 100%;
  position: absolute;
}
.slider .navigations .dots {
  height: 20px;
  padding: 10px 0px;
  text-align: center;
}
.slider .navigations .dots li {
  width: 10px;
  height: 10px;
  cursor: pointer;
  transition: 0.3s;
  background: #fff;
  border-radius: 50%;
  display: inline-block;
  vertical-align: middle;
}
.slider .navigations .dots li + li {
  margin-left: 10px;
}
.slider .navigations .dots li:hover {
  filter: blur(2px);
}
.slider .navigations .dots li.active {
  width: 15px;
  height: 15px;
}
.slider .navigations .dots li.active:hover {
  filter: blur(0px);
}
</style>