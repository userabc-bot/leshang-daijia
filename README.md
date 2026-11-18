# 乐尚代驾（后端）

网约车平台实战项目的后端代码，采用 Spring Cloud 微服务架构，包含乘客端、司机端和管理端三个入口。

> 课程实战项目整理版。原项目依赖 Nacos 配置中心，本仓库不包含配置导出文件与支付证书（其中含凭据），启动前需自行准备。

## 技术栈

- Java 17 / Spring Boot 3.0.5 / Spring Cloud 2022.0.2 + Spring Cloud Alibaba
- Nacos 注册与配置中心、Spring Cloud Gateway、OpenFeign
- MyBatis-Plus、MySQL 8、Redis + Redisson、RabbitMQ
- Seata（分布式事务）、XXL-Job（调度）、Drools（规则引擎）
- 微信支付、腾讯云、MinIO、Knife4j

## 模块结构

| 模块 | 说明 |
| --- | --- |
| `common` | 公共组件：日志、工具类、RabbitMQ 封装、Spring Security 扩展 |
| `model` | 实体、DTO、VO |
| `server-gateway` | 统一网关 |
| `service` | 业务微服务：订单、派单、司机、乘客、支付、优惠券、地图、规则、系统、消息 |
| `service-client` | 各服务的 Feign 客户端 |
| `web` | 三端接口层：`web-customer`（乘客）、`web-driver`（司机）、`web-mgr`（管理） |

## 本地运行

1. 准备 MySQL 8、Redis、RabbitMQ，以及 Nacos（各服务 `bootstrap.properties` 中配置了 Nacos 地址）。
2. 在 Nacos 中导入各服务的 `*-dev.yaml` 配置，填写数据库、Redis、消息队列等连接信息。
3. 微信支付私钥 `apiclient_key.pem` 需自行放入 `service/service-payment/src/main/resources/`（未随仓库提供）。
4. 依次启动 `server-gateway` 与所需微服务，例如：

```bash
mvn -pl server-gateway spring-boot:run
mvn -pl web/web-mgr spring-boot:run
```
