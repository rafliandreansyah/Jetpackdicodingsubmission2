# Jetpackdicodingsubmission2
Submission 2 android jetpack pro

![Home screen](https://user-images.githubusercontent.com/47078618/76595447-3b89a980-652e-11ea-8c30-47eae7ff7e8d.jpg) 
![detail movie](https://user-images.githubusercontent.com/47078618/76595467-43e1e480-652e-11ea-97aa-6bf5c0c08b4f.jpg)

Aplikasi movie catalog mengambil data dari API https://www.themoviedb.org/ secara asynchronous

Pada aplikasi ini menerapkan:
- Pengambilan data menggunakan library loopj
- Viewmodel, Livedata dan repository
- Pengujian menggunakan Unit testing dan Instrumentation testing


Skenario Instrumentation Testing: 

Menampilkan data Movie
  - Menampilkan rv_movies dalam keadaan tampil
  - Menggulir rv_movies sampai item ke 20
Menampilkan detail movie
  - Memberikan tindakan klik pada rv_movies pada item atau data pada posisi pertama
  - Memastikan tv_title_movie_detail dalam keadaan tampil
  - Memastikan tv_title_movie_detail tampil sesuai dengan data yang diharapkan
  - Memastikan tv_release_movie_detail dalam keadaan tampil
  - Memastikan tv_release_movie_detail tampil sesuai dengan data yang diharapkan
  - Memastikan tv_rating_movie_detail dalam keadaan tampil
  - Memastikan tv_rating_movie_detail tampil sesuai dengan data yang diharapkan
  - Memastikan tv_overview_movie_detail dalam keadaan tampil
  - Memastikan tv_overview_movie_detail tampil sesuai dengan data yang diharapkan
Menampilkan data Tv
  - Memberikan tindakan klik pada tab layout dengan teks Tv Show
  - Menampilan rv_tvshow dalam keadaan tampil
  - Menggulir rv_tvshow sampai item ke 20
Menampilkan detail Tv
  - Memberikan tindakan klik pada tab layout dengan teks Tv Show
  - Memberikan tidakan klik pada rv_tvshow pada item atau data pada posisi pertama
  - Memastikan tv_title_tv_detail dalam keadaan tampil
  - Memastikan tv_title_tv_detail tampil sesuai dengan data yang diharapkan
  - Memastikan tv_release_tv_detail dalam keadaan tampil
  - Memastikan tv_release_tv_detail tampil sesuai dengan data yang diharapkan
  - Memastikan tv_rating_tv_detail dalam keadaan tampil
  - Memastikan tv_rating_tv_detail tampil sesuai dengan data yang diharapkan
  - Memastikan tv_overview_tv_detail dalam keadaan tampil
  - Memastikan tv_overview_tv_detail tampil sesuai dengan data yang diharapkan
