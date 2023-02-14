# Problem Set 6

## Test API index#1

Chức năng: Thêm một tutorial

URL: `/api/tutorials`

```bash
curl -s -i -X POST -H "Content-Type: application/json" --data-raw '{
  "title": "title1",
  "description": "description1",
  "published": false
}' http://localhost:8080/api/tutorials
```

Kết quả trả về của command trên:

```bash
HTTP/1.1 201
Content-Type: application/json
Transfer-Encoding: chunked
Date: Tue, 14 Feb 2023 11:57:35 GMT

{"id":1,"title":"title1","description":"description1","published":false}
```

Thêm một tutorial khác:

```bash
curl -s -i -X POST -H "Content-Type: application/json" --data-raw '{
  "title": "title2",
  "description": "description2",
  "published": true
}' http://localhost:8080/api/tutorials
```

## Test API index#2

Chức năng: Hiển thị các tutorial hiện có

URL: `/api/tutorials`

```bash
curl -i http://localhost:8080/api/tutorials
```

Kết quả trả về của command trên:

```bash
HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Tue, 14 Feb 2023 12:09:49 GMT

[{"id":1,"title":"title1","description":"description1","published":false},{"id":2,"title":"title2","description":"description2","published":true}]
```

JSON prettier:

```bash
curl -i http://localhost:8080/api/tutorials | tail -n1 | jq .

  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100   146    0   146    0     0  13557      0 --:--:-- --:--:-- --:--:-- 36500

[
  {
    "id": 1,
    "title": "title1",
    "description": "description1",
    "published": false
  },
  {
    "id": 2,
    "title": "title2",
    "description": "description2",
    "published": true
  }
]
```

## Test API index#3

Chức năng: Hiển thị tutorial qua id

URL: `/api/tutorials/id`

```bash
curl -i http://localhost:8080/api/tutorials/1
```

Kết quả trả về của command trên:

```bash
HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Tue, 14 Feb 2023 12:14:53 GMT

{"id":1,"title":"title1","description":"description1","published":false}
```

## Test API index#4

Chức nặng: Cập nhật tutorial qua id

URL: `/api/tutorials/id`

```bash
curl -s -i -X PUT -H "Content-Type: application/json" --data-raw '{
  "title": "title update 1",
  "description": "description updated 1",
  "published": true
}' http://localhost:8080/api/tutorials/1
```

Kết quả trả về cho command trên:

```bash
HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Tue, 14 Feb 2023 12:17:17 GMT

{"id":1,"title":"title update 1","description":"description updated 1","published":true}
```

## Test API index#5

Chức nặng: Xoá tutorial qua id

URL: `/api/tutorials/id`

```bash
curl -i -X DELETE  http://localhost:8080/api/tutorials/2
```

Kết quả trả về cho command trên:

```bash
HTTP/1.1 204
Date: Tue, 14 Feb 2023 12:20:08 GMT
```

## Test API index#6

Chức năng: Xoá tất cả tutorial

URL: `/api/tutorials`

```bash
curl -i -X DELETE  http://localhost:8080/api/tutorials
```

Kết quả trả về cho command trên

```bash
HTTP/1.1 204
Date: Tue, 14 Feb 2023 12:23:45 GMT
```

## Test API index#7

Chức năng: Hiển thị những tutorial được published (published == true)

URL: `/api/tutorials/published`

```bash
curl -i localhost:8080/api/tutorials/published
```

Kết quả trả về cho command trên:

```bash
HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Tue, 14 Feb 2023 12:27:37 GMT

[{"id":4,"title":"title 5","description":"description 5","published":true},{"id":6,"title":"title 6","description":"description 6","published":true}]
```

JSON prettier:

```bash
curl -i localhost:8080/api/tutorials/published | tail -n1 | jq .
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100   149    0   149    0     0  13812      0 --:--:-- --:--:-- --:--:-- 37250
[
  {
    "id": 4,
    "title": "title 5",
    "description": "description 5",
    "published": true
  },
  {
    "id": 6,
    "title": "title 6",
    "description": "description 6",
    "published": true
  }
]
```

## Test API index#8

Chức năng: Tìm tutorial qua parameter

Dữ liệu đang có trong H2 database:

<img width="713" alt="Screenshot 2023-02-14 at 19 39 52" src="https://user-images.githubusercontent.com/109766527/218741464-27d930f5-ae13-4866-b59a-80a28b32c3b5.png">

URL: `/api/tutorial` với parameter là một title (vd. "title 5")

```bash
curl -i  "http://localhost:8080/api/tutorials?title=title%205"
```

Kết quả trả về cho command trên:

```bash
HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Tue, 14 Feb 2023 12:36:24 GMT

[{"id":4,"title":"title 5","description":"description 5","published":true},{"id":5,"title":"title 5 real","description":"description 5 real","published":false}]
```

Prettier JSON:

```bash
curl -i  "http://localhost:8080/api/tutorials?title=title%205" | tail -n1 | jq .

  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100   160    0   160    0     0  14237      0 --:--:-- --:--:-- --:--:-- 32000
[
  {
    "id": 4,
    "title": "title 5",
    "description": "description 5",
    "published": true
  },
  {
    "id": 5,
    "title": "title 5 real",
    "description": "description 5 real",
    "published": false
  }
]
```
