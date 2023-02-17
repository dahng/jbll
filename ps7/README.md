# Interceptor and Filter

## Demonstration

- Log file when access an endpoint from browser: Line 23, 32, 43

```
 1	Host: localhost:8080
 2	Connection: keep-alive
 3	Upgrade-Insecure-Requests: 1
 4	User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36
 5	Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8
 6	Sec-GPC: 1
 7	Sec-Fetch-Site: none
 8	Sec-Fetch-Mode: navigate
 9	Sec-Fetch-User: ?1
10	Sec-Fetch-Dest: document
11	Accept-Language: en-US,en
12	Accept-Encoding: gzip, deflate, br
13	Cookie: io=emcNX_kE-AoaEpKBAAAP
14
15	]
16	  2023-02-17 16:18:25.767 DEBUG [http-nio-8080-exec-2] o.a.t.u.http.Rfc6265CookieProcessor - Cookies: Parsing b[]: io=emcNX_kE-AoaEpKBAAAP
17	  2023-02-17 16:18:25.768 DEBUG [http-nio-8080-exec-2] o.a.c.a.AuthenticatorBase - Security checking request GET /likelion/
18	  ...
19	  2023-02-17 16:18:25.781 DEBUG [http-nio-8080-exec-2] o.apache.tomcat.util.http.Parameters - Set encoding to UTF-8
20	  2023-02-17 16:18:25.781 TRACE [http-nio-8080-exec-2] o.s.web.servlet.DispatcherServlet - GET "/likelion/", parameters={}, headers={masked} in DispatcherServlet 'dispatcherServlet'
21	  2023-02-17 16:18:25.787 TRACE [http-nio-8080-exec-2] o.s.w.s.h.SimpleUrlHandlerMapping - Mapped to HandlerExecutionChain with [ResourceHttpRequestHandler [classpath [META-INF/resources/], classpath [resources/], classpath [static/], classpath [public/], ServletContext [/]]] and 5 interceptors
22
23	2023-02-17 16:18:25.791 INFO  [http-nio-8080-exec-2] c.l.p.interceptor.LoggingInterceptor - Pre Handle method is Calling
24
25	  2023-02-17 16:18:25.792 DEBUG [http-nio-8080-exec-2] o.s.o.j.s.OpenEntityManagerInViewInterceptor - Opening JPA EntityManager in OpenEntityManagerInViewInterceptor
26	  2023-02-17 16:18:25.792 TRACE [http-nio-8080-exec-2] o.h.i.SessionFactoryImpl$SessionBuilderImpl - Opening Hibernate Session.  tenant=null
27	  2023-02-17 16:18:25.814 TRACE [http-nio-8080-exec-2] o.h.s.i.AbstractServiceRegistryImpl - Initializing service [role=org.hibernate.stat.spi.StatisticsImplementor]
28	  2023-02-17 16:18:25.816 DEBUG [http-nio-8080-exec-2] o.h.s.internal.StatisticsInitiator - Statistics initialized [enabled=false]
29	  2023-02-17 16:18:25.818 TRACE [http-nio-8080-exec-2] org.hibernate.internal.SessionImpl - Opened Session [95af146d-f4dd-49b9-bdd9-a41a25d0efff] at timestamp: 1676625505803
30	  2023-02-17 16:18:25.819 DEBUG [http-nio-8080-exec-2] o.s.w.s.r.ResourceHttpRequestHandler - Resource not found
31
32	2023-02-17 16:18:25.819 INFO  [http-nio-8080-exec-2] c.l.p.interceptor.LoggingInterceptor - Post Handle method is Calling
33
34	  2023-02-17 16:18:25.820 INFO  [http-nio-8080-exec-2] c.l.p.interceptor.LoggingInterceptor - Execution time: 28ms
35	  2023-02-17 16:18:25.820 TRACE [http-nio-8080-exec-2] o.s.web.servlet.DispatcherServlet - No view rendering, null ModelAndView returned.
36	  2023-02-17 16:18:25.820 DEBUG [http-nio-8080-exec-2] o.s.o.j.s.OpenEntityManagerInViewInterceptor - Closing JPA EntityManager in OpenEntityManagerInViewInterceptor
37	  2023-02-17 16:18:25.820 TRACE [http-nio-8080-exec-2] org.hibernate.internal.SessionImpl - Closing session [95af146d-f4dd-49b9-bdd9-a41a25d0efff]
38	  2023-02-17 16:18:25.820 TRACE [http-nio-8080-exec-2] o.h.e.j.internal.JdbcCoordinatorImpl - Closing JDBC container [org.hibernate.engine.jdbc.internal.JdbcCoordinatorImpl@3a76857f]
39	  2023-02-17 16:18:25.820 TRACE [http-nio-8080-exec-2] o.h.r.j.i.ResourceRegistryStandardImpl - Releasing JDBC resources
40	  2023-02-17 16:18:25.820 TRACE [http-nio-8080-exec-2] o.h.r.j.i.LogicalConnectionManagedImpl - Closing logical connection
41	  2023-02-17 16:18:25.820 TRACE [http-nio-8080-exec-2] o.h.r.j.i.LogicalConnectionManagedImpl - Logical connection closed
42
43	2023-02-17 16:18:25.821 INFO  [http-nio-8080-exec-2] c.l.p.interceptor.LoggingInterceptor - Request and Response is completed
44
45	  2023-02-17 16:18:25.821 DEBUG [http-nio-8080-exec-2] o.s.web.servlet.DispatcherServlet - Completed 404 NOT_FOUND, headers={masked}
46	  2023-02-17 16:18:25.821 TRACE [http-nio-8080-exec-2] o.s.b.f.s.DefaultListableBeanFactory - Returning cached instance of singleton bean 'springApplicationAdminRegistrar'
47	  2023-02-17 16:18:25.821 TRACE [http-nio-8080-exec-2] o.s.b.w.s.f.OrderedRequestContextFilter - Cleared thread-bound request context: org.apache.catalina.connector.RequestFacade@6a44e40e
48	  2023-02-17 16:18:25.821 DEBUG [http-nio-8080-exec-2] o.a.c.c.C.[Tomcat].[localhost] - Processing ErrorPage[errorCode=0, location=/error]
49	  2023-02-17 16:18:25.824 DEBUG [http-nio-8080-exec-2] o.a.catalina.core.StandardWrapper -   Returning instance
50	  2023-02-17 16:18:25.824 TRACE [http-nio-8080-exec-2] o.s.b.w.s.f.OrderedRequestContextFilter - Bound request context to thread: org.apache.catalina.core.ApplicationHttpRequest@23f5bec
51	  2023-02-17 16:18:25.825 TRACE [http-nio-8080-exec-2] o.s.web.servlet.DispatcherServlet - "ERROR" dispatch for GET "/likelion/error", parameters={}, headers={masked} in DispatcherServlet 'dispatcherServlet'
52	  2023-02-17 16:18:25.825 TRACE [http-nio-8080-exec-2] o.s.w.s.m.m.a.RequestMappingHandlerMapping - 2 matching mappings: [{ [/error], produces [text/html]}, { [/error]}]
53	  2023-02-17 16:18:25.826 TRACE [http-nio-8080-exec-2] o.s.b.f.s.DefaultListableBeanFactory - Returning cached instance of singleton bean 'basicErrorController'
54	  2023-02-17 16:18:25.826 TRACE [http-nio-8080-exec-2] o.s.w.s.m.m.a.RequestMappingHandlerMapping - Mapped to org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController#errorHtml(HttpServletRequest, HttpServletResponse)
55

```

- Accessing by `curl` or other non-browser application:

```bash
curl -i localhost:8080/likelion/departments
```

```text
HTTP/1.1 403
Content-Type: text/plain;charset=ISO-8859-1
Content-Length: 88
Date: Fri, 17 Feb 2023 09:43:46 GMT

Access denied: You are not authorized to access this resource from a non-browser client.
```
