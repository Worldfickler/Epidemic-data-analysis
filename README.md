# 项目计划进度表

11.20 ---- 后端项目初始化
计划采用前后端分离实现
技术点：
1. 后端 springboot 2.7.5
2. 前端 echars

依赖版本
1. hadoop-client（3.1.3）
2. junit（4.12）
3. slf4j-log4j12（1.7.30）

项目计划实现
1. 累计确认、现存疑似、现存重症、死亡、治愈，数据展示
2. 以上数据地图展示
3. 每日新增情况（折线图展示-日期为x轴）
4. 病患总排名（柱状图展示-地区为x轴）
5. 病患类型比例（饼状图）
6. 治愈率-死亡率分布（病状分布图-治愈率为x轴，死亡率为y轴）
7. 病患年龄分布（柱状图-年龄段为x轴）
8. 感染按人口密度排名（柱状图-地区为x轴）
9. 感染按面积密度排名（柱状图-地区为x轴）
10. 病患总数排名（柱状图-地区为x轴）
11. 月份病患比例图


11.21 ---- 确定数据字典

**overall**
| 变量名 | 注释 |
|--|--|
| generalRemark | 全国疫情信息概览 |
| remarkX | 注释内容，X为1~5 |
| note1 | 	病毒名称 |
| note2 | 传染源 |
| note3 | 传播途径 |
| currentConfirmedCount(Incr) | 现存确诊人数（较昨日增加数量）值为confirmedCount(Incr) - curedCount(Incr) - deadCount(Incr) |
| confirmedCount(Incr) | 	累计确诊人数（较昨日增加数量） |
| suspectedCount(Incr) | 疑似感染人数（较昨日增加数量） |
| curedCount(Incr) | 治愈人数（较昨日增加数量） |
| deadCount(Incr) | 死亡人数（较昨日增加数量） |
| seriousCount(Incr) | 重症病例人数（较昨日增加数量） |
| updateTime | 	数据最后变动时间 |


**area**
| 变量名 |注释  |
|--|--|
| city_zipCode |城市编号  中国大陆城市编号为邮编，中国大陆以外城市编号暂不知规则   |
| continentEnglishName | 大洲英文名 |
| countryEnglishName | 国家英文名 |
| provinceEnglishName | 省英文名 |
| cityEnglishName | 城市英文名 |
| province_confirmedCount | 省累计感染人数 |
| province_suspectedCount | 省疑似感染人数 |
| province_curedCount | 省治愈人数 |
| province_deadCount |  省死亡人数|
| city_confirmedCount | 城市累计感染人数 |
| city_suspectedCount | 城市疑似感染人数 |
| city_curedCount | 城市治愈人数 |
| city_deadCount |  城市死亡人数|
| updateTime | 更新时间 |

**news**
| 变量名 | 注释 |
|--|--|
| infoSource | 信息源 |
| _id |信息编号  |
| id | 信息副编号 |
| title | 标题 |
| summary | 摘要 |
| sourceUrl| 来源网址 |
| articleId | 文章编号 |
| category | 类别 |

**rumors**
| 变量名 | 注释 |
|--|--|
| id | 谣言编号 |
| title | 谣言标题 |
| mainSummary | 辟谣内容概述 |
| body | 谣言内容 |
| sourceUrl | 来源链接 |


11.22 ---- hadoop框架初始搭建

跑通demo-wordcount


11.23 ---- 写完第一个示例mapreduce

统计某个城市累计感染人数、城市疑似感染人数、城市治愈人数、城市死亡人数

存在问题：
1. 数据是否需要先进行第一步的清洗，对于部分字段没有的的单条数据，好像程序会出现问题...
2. 测试仅测试了几百条的数据，对于上百万条的数据，还尚未测试...
3. 有些数据的key是相同的但是，代表的含义不同（城市代码相同 -1、0）
