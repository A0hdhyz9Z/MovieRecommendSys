s=[F'var movie{i} = Movie.builder().originalTitle(String.valueOf(i*i)).build();\nmovies.add(movie{i});\nrecommendation.setMovie1(movie{i});' for i in range(1,21)]

print(s)

a=""

for i in s:
    a=a+i

print(a)