# 🥖 Review_System_Redis_Project
## 🥑 Project Description
A review system based on SpringBoot and Redis. Through distributed locks and Redis data structures, it implements scenarios such as flash sales, high concurrency, and geographical location.
<br>
<img width="800" alt="image" src="https://github.com/Tyler03118/DianPing_Redis_Project/assets/113784268/c19e3a58-bc29-4138-9b37-84ea736928fd">

## ⚗️ Skills
| Skills         | Usage | Official Website         |
| ------------------ | ------------- | ----------------------------------------------- |
| SpringBoot         | Container+MVC Framework | https://spring.io/projects/spring-boot          |
| MyBatis-Plus       | ORM Framework     | https://mp.baomidou.com                         |
| Mysql   | Database            | https://www.mysql.com                    |
| Redis   | Database for cache        | https://redis.io/download                |
| ElasticSearch| Geographic Search | https://elastic.co
| Docker             | Container | https://www.docker.com                          |

## 🛰️ Project Highlights
- Preloads data for popular scenarios weekly and has a simple program to prevent cache penetration.
- Utilizes Redisson distributed locks to address the overselling of scenario coupons, ensuring data atomicity under concurrency through Lua scripts.
- Employs Sorted Set to create a 'like' ranking system, presenting users with the most popular scenario data.
- Taps into Geospatial features to provide basic geographical location information, streamlining shop searches.
- Uses Bitmap to facilitate user check-in functionality.
