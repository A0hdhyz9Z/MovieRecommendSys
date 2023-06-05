<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="4" v-for="(movie, index) in paginatedMovies" :key="index">
        <movie-card :movie="movie" @click="showMovieDetails(movie)"></movie-card>
      </el-col>
    </el-row>

    <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page.sync="currentPage"
        :page-size="pageSize"
        layout="total, prev, pager, next, jumper"
        :total="movies.length"
    ></el-pagination>

    <!--    <el-dialog :visible.sync="isMovieDetailsModalVisible" :before-close="handleClose" width="50%">-->
    <el-dialog v-if="selectedMovie" v-model="isMovieDetailsModalVisible" :before-close="handleClose" width="50%">
      <div v-if="selectedMovie">
        <div class="dialog-content">
          <div class="poster-section">
            <h2>{{ selectedMovie.title }}</h2>
            <img :src="selectedMovie.posterUrl" :alt="selectedMovie.title" class="poster"/>
          </div>
          <div class="details">
            <p><strong>评分：</strong> {{ selectedMovie.rating }} / 5</p>
            <p><strong>导演：</strong> {{ selectedMovie.director }}</p>
            <p><strong>主演：</strong> {{ selectedMovie.cast.join(', ') }}</p>
            <p><strong>简介：</strong> {{ selectedMovie.description }}</p>
          </div>
        </div>
      </div>
      <!--      <span slot="footer" class="dialog-footer">
              <el-button @click="handleClose">关闭</el-button>
            </span>-->
      <el-button
          class="favorite-button"
          :type="favorites.includes(selectedMovie) ? 'danger' : 'info'"
          icon="el-icon-star"
          @click="toggleFavorite(selectedMovie)"
      >
        <el-icon><StarFilled /></el-icon>
        收藏</el-button>
    </el-dialog>
  </div>
</template>

<script>
import MovieCard from "./MovieCard.vue";
import axios from "axios";

export default {
  components: {
    MovieCard,
  },
  data() {
    return {
      // movies: [], // 从API或其他来源获取的电影数据
      movies: [
        {
          id: 1,
          title: "星际穿越",
          posterUrl: "https://upload.wikimedia.org/wikipedia/zh/b/bc/Interstellar_film_poster.jpg",
          rating: 4.6,
          director: "克里斯托弗·诺兰",
          cast: ["马修·麦康纳", "安妮·海瑟薇", "杰西卡·查斯坦"],
          description: "一部讲述人类探索宇宙奥秘的科幻巨作。",
        },

      ],
      currentPage: 1,
      pageSize: 30,
      isMovieDetailsModalVisible: false,
      selectedMovie: null,
      favorites: [],
    };
  },
  computed: {
    paginatedMovies() {
      const start = (this.currentPage - 1) * this.pageSize;
      const end = start + this.pageSize;
      return this.movies.slice(start, end);
    },
  },
  methods: {
    async fetchMovies() {
      // 从API或其他来源获取电影数据，并将其分配给 `this.movies`
      /*      try {
              const response = await axios.get("https://example.com/api/movies");
              this.movies = response.data;
            } catch (error) {
              console.error("Error fetching movies:", error);
            }*/
    },
    toggleFavorite(movie) {
      if (this.favorites.includes(movie)) {
        // 如果电影已经被收藏，从收藏列表中移除
        const index = this.favorites.indexOf(movie);
        if (index !== -1) {
          this.favorites.splice(index, 1);
        }

        // Send HTTP request to delete the movie from favorites
        axios
            .delete(`https://example.com/api/favorites/${movie.id}`)
            .then(response => {
              // handle success
              console.log(response);
            })
            .catch(error => {
              // handle error
              console.error("Error removing favorite movie:", error);
            });
      } else {
        // 如果电影还没有被收藏，添加到收藏列表中
        this.favorites.push(movie);

        // Send HTTP request to add the movie to favorites
        axios
            .post("https://example.com/api/favorites", movie)
            .then(response => {
              // handle success
              console.log(response);
            })
            .catch(error => {
              // handle error
              console.error("Error adding favorite movie:", error);
            });
      }
    },

    handleSizeChange(val) {
      this.pageSize = val;
      this.handleCurrentChange(1);
    },
    handleCurrentChange(val) {
      this.currentPage = val;
    },
    showMovieDetails(movie) {
      console.log('~~~~~~~~~~~~~~~~~~~~~~~~~~')
      this.selectedMovie = movie;
      this.isMovieDetailsModalVisible = true;
      this.$nextTick(() => {
        console.log('Visible----prop:', this.isMovieDetailsModalVisible);
      });

      // console.log(this.isMovieDetailsModalVisible)
      // console.log(this.selectedMovie)
    },
    handleClose() {
      this.isMovieDetailsModalVisible = false;
    },
  },
  mounted() {
    this.fetchMovies();
  },
};
</script>

<style scoped>
.dialog-content {
  display: flex;
  justify-content: space-between;
}

.poster-section {
  width: 50%;
  text-align: center;
}

.poster-section h2 {
  text-align: center;
}

.poster-section .poster {
  width: 100%;
}

.details {
  width: 50%;
  padding-left: 20px;  /* add some padding so the text isn't right up against the image */
}

.poster {
  max-width: 350px;
  height: auto;
}
.details p {
  font-size: 20px;
}

.favorite-button {
  position: absolute;
  bottom: 20px;
  right: 10px;
  width: 65px;
}


</style>
