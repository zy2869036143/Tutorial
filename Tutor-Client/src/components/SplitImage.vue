<template>
    
<div id="container">
  <ul id="slides">
    <li class="slide">
      <div class="slide-partial slide-left"><img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/544318/forest-left.jpg"/></div>
      <div class="slide-partial slide-right"><img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/544318/forest-right.jpg"/></div>
      <h1 class="title"><span class="title-text">Forest</span></h1>
    </li>
    <li class="slide">
      <div class="slide-partial slide-left"><img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/544318/mountain-left.jpg"/></div>
      <div class="slide-partial slide-right"><img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/544318/mountain-right.jpg"/></div>
      <h1 class="title"><span class="title-text">Mountain</span></h1>
    </li>
    <li class="slide">
      <div class="slide-partial slide-left"><img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/544318/ocean-left.jpg"/></div>
      <div class="slide-partial slide-right"><img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/544318/ocean-right.jpg"/></div>
      <h1 class="title"><span class="title-text">Ocean</span></h1>
    </li>
    <li class="slide">
      <div class="slide-partial slide-left"><img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/544318/canyon-left.jpg"/></div>
      <div class="slide-partial slide-right"><img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/544318/canyon-right.jpg"/></div>
      <h1 class="title"><span class="title-text">Canyon</span></h1>
    </li>
    <li class="slide">
      <div class="slide-partial slide-left"><img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/544318/lake-left.jpg"/></div>
      <div class="slide-partial slide-right"><img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/544318/lake-right.jpg"/></div>
      <h1 class="title"><span class="title-text">Lake</span></h1>
    </li>
  </ul>
  <ul id="slide-select">
    <li class="btn prev">&#60;</li>
    <li class="selector"></li>
    <li class="selector"></li>
    <li class="selector"></li>
    <li class="selector"></li>
    <li class="selector"></li>
    <li class="btn next">></li>
  </ul>
</div>

</template>

<style scoped>
* {
  box-sizing: border-box;
}

body {
  background-color: #0c0c0c;
  overflow: hidden;
}

#container {
  position: absolute;
  width: 100%;
  height: 100%;
  overflow: hidden;
}

#slides {
  position: relative;
  width: 100%;
  height: 100%;
}
#slides .slide {
  position: absolute;
  display: flex;
  width: 100%;
  height: 100%;
}
#slides .slide .title {
  position: absolute;
  top: calc(50% - 0.5em);
  left: 20px;
  z-index: 2;
  padding-top: 5px;
  font-family: "Reem Kufi", sans-serif;
  font-size: 5em;
  color: white;
  overflow: hidden;
}
#slides .slide .title .title-text {
  display: block;
  transform: translateY(1.2em);
  transition: transform 1s ease-in-out;
}
#slides .slide .slide-partial {
  position: absolute;
  width: 50%;
  height: 100%;
  overflow: hidden;
  transition: transform 1s ease-in-out;
}
#slides .slide .slide-partial img {
  position: absolute;
  z-index: 1;
  width: 100%;
  height: 100%;
  -o-object-fit: cover;
     object-fit: cover;
  transition: transform 1s ease-in-out;
}
#slides .slide .slide-left {
  top: 0;
  left: 0;
  transform: translateX(-100%);
}
#slides .slide .slide-left img {
  top: 0;
  right: 0;
  -o-object-position: 100% 50%;
     object-position: 100% 50%;
  transform: translateX(50%);
}
#slides .slide .slide-right {
  top: 0;
  right: 0;
  transform: translateX(100%);
  transition-delay: 0.2s;
}
#slides .slide .slide-right img {
  top: 0;
  left: 0;
  -o-object-position: 0% 50%;
     object-position: 0% 50%;
  transition-delay: 0.2s;
  transform: translateX(-50%);
}
#slides .slide.active .title .title-text {
  transform: translate(0);
  transition-delay: 0.3s;
}
#slides .slide.active .slide-partial, #slides .slide.active .slide-partial img {
  transform: translateX(0);
}

#slide-select {
  position: relative;
  bottom: 20px;
  left: 20px;
  z-index: 100;
  display: flex;
  align-items: center;
  justify-content: space-around;
  font-family: "Reem Kufi", sans-serif;
  font-size: 1.5em;
  font-weight: lighter;
  color: white;
}
#slide-select li {
  position: relative;
  cursor: pointer;
  margin: 0 5px;
}
#slide-select li.prev:hover {
  transform: translateX(-2px);
}
#slide-select li.next:hover {
  transform: translateX(2px);
}
#slide-select .selector {
  height: 14px;
  width: 14px;
  border: 2px solid white;
  background-color: transparent;
  transition: background-color 0.5s ease-in-out;
}
#slide-select .selector.current {
  background-color: white;
}

.codepen-link {
  position: absolute;
  bottom: 20px;
  right: 20px;
  height: 40px;
  width: 40px;
  z-index: 10;
  border-radius: 50%;
  box-sizing: border-box;
  background-image: url("https://s3-us-west-2.amazonaws.com/s.cdpn.io/544318/logo.jpg");
  background-position: center center;
  background-size: cover;
  opacity: 0.5;
  transition: all 0.25s;
}
.codepen-link:hover {
  opacity: 0.8;
  box-shadow: 0 2px 6px #0c0c0c;
}
</style>
<script>

export default{
    mounted(){
        let $slides, interval, $selectors, $btns, currentIndex, nextIndex;

let cycle = index => {
  let $currentSlide, $nextSlide, $currentSelector, $nextSelector;

  nextIndex = index !== undefined ? index : nextIndex;

  $currentSlide = $($slides.get(currentIndex));
  $currentSelector = $($selectors.get(currentIndex));

  $nextSlide = $($slides.get(nextIndex));
  $nextSelector = $($selectors.get(nextIndex));

  $currentSlide.removeClass("active").css("z-index", "0");

  $nextSlide.addClass("active").css("z-index", "1");

  $currentSelector.removeClass("current");
  $nextSelector.addClass("current");

  currentIndex = index !== undefined ?
  nextIndex :
  currentIndex < $slides.length - 1 ?
  currentIndex + 1 :
  0;

  nextIndex = currentIndex + 1 < $slides.length ? currentIndex + 1 : 0;
};

$(() => {
  currentIndex = 0;
  nextIndex = 1;

  $slides = $(".slide");
  $selectors = $(".selector");
  $btns = $(".btn");

  $slides.first().addClass("active");
  $selectors.first().addClass("current");

  interval = window.setInterval(cycle, 6000);

  $selectors.on("click", e => {
    let target = $selectors.index(e.target);
    if (target !== currentIndex) {
      window.clearInterval(interval);
      cycle(target);
      interval = window.setInterval(cycle, 6000);
    }
  });

  $btns.on("click", e => {
    window.clearInterval(interval);
    if ($(e.target).hasClass("prev")) {
      let target = currentIndex > 0 ? currentIndex - 1 : $slides.length - 1;
      cycle(target);
    } else if ($(e.target).hasClass("next")) {
      cycle();
    }
    interval = window.setInterval(cycle, 6000);
  });
});
    }
}

</script>
