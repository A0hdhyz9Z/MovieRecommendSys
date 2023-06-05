<template>
  <div class="movie-card">
    <img class="movie-poster" :src="movie.posterUrl" :alt="movie.title" />
    <div>
      <h3 class="movie-title">{{ movie.title }}</h3>
    </div>
    <div class="rating">
      <el-rate v-model="movie.rating" :colors="['#99A9BF', '#F7BA2A', '#FF9900']" :max="5" disabled></el-rate>
    </div>
  </div>
</template>
<script>
export default {
  props: {
    movie: {
      type: Object,
      required: true,
    },
  },
};
</script>

<style scoped>
.movie-card {
  cursor: pointer;
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
}

.movie-poster {
  width: 200px;  /* 调整宽度 */
  height: 300px;  /* 调整高度 */
  object-fit: cover; /* 确保图片总是填充整个容器，可能会有部分图片被裁剪 */
}

.rating {
  margin-top: 5px;
}

.movie-title {
  margin-bottom: 5px;
}

</style>
