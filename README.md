# 项目计划进度表

11.20 ---- 后端项目初始化
计划采用前后端分离实现
技术点：
1. 后端 springboot
2. 前端 echars

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
