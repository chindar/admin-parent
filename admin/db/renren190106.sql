/*
Navicat MySQL Data Transfer

Source Server         : admin
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : renren

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-01-07 06:43:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_business
-- ----------------------------
DROP TABLE IF EXISTS `sys_business`;
CREATE TABLE `sys_business` (
  `business_id` tinyint(3) NOT NULL AUTO_INCREMENT COMMENT '业务id',
  `business_name` varchar(255) DEFAULT NULL COMMENT '业务名称',
  PRIMARY KEY (`business_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_business
-- ----------------------------

-- ----------------------------
-- Table structure for sys_city
-- ----------------------------
DROP TABLE IF EXISTS `sys_city`;
CREATE TABLE `sys_city` (
  `city_id` int(20) NOT NULL,
  `city_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_city
-- ----------------------------
INSERT INTO `sys_city` VALUES ('1', '北京');
INSERT INTO `sys_city` VALUES ('2', '天津');
INSERT INTO `sys_city` VALUES ('3', '石家庄');
INSERT INTO `sys_city` VALUES ('4', '唐山');
INSERT INTO `sys_city` VALUES ('5', '秦皇岛');
INSERT INTO `sys_city` VALUES ('6', '邯郸');
INSERT INTO `sys_city` VALUES ('7', '邢台');
INSERT INTO `sys_city` VALUES ('8', '保定');
INSERT INTO `sys_city` VALUES ('9', '张家口');
INSERT INTO `sys_city` VALUES ('10', '承德');
INSERT INTO `sys_city` VALUES ('11', '沧州');
INSERT INTO `sys_city` VALUES ('12', '廊坊');
INSERT INTO `sys_city` VALUES ('13', '衡水');
INSERT INTO `sys_city` VALUES ('14', '太原');
INSERT INTO `sys_city` VALUES ('15', '大同');
INSERT INTO `sys_city` VALUES ('16', '阳泉');
INSERT INTO `sys_city` VALUES ('17', '长治');
INSERT INTO `sys_city` VALUES ('18', '晋城');
INSERT INTO `sys_city` VALUES ('19', '朔州');
INSERT INTO `sys_city` VALUES ('20', '晋中');
INSERT INTO `sys_city` VALUES ('21', '运城');
INSERT INTO `sys_city` VALUES ('22', '忻州');
INSERT INTO `sys_city` VALUES ('23', '临汾');
INSERT INTO `sys_city` VALUES ('24', '吕梁');
INSERT INTO `sys_city` VALUES ('25', '呼和浩特');
INSERT INTO `sys_city` VALUES ('26', '包头');
INSERT INTO `sys_city` VALUES ('27', '乌海');
INSERT INTO `sys_city` VALUES ('28', '赤峰');
INSERT INTO `sys_city` VALUES ('29', '通辽');
INSERT INTO `sys_city` VALUES ('30', '鄂尔多斯');
INSERT INTO `sys_city` VALUES ('31', '呼伦贝尔');
INSERT INTO `sys_city` VALUES ('32', '巴彦淖尔');
INSERT INTO `sys_city` VALUES ('33', '乌兰察布');
INSERT INTO `sys_city` VALUES ('34', '兴安');
INSERT INTO `sys_city` VALUES ('35', '锡林郭勒');
INSERT INTO `sys_city` VALUES ('36', '阿拉善');
INSERT INTO `sys_city` VALUES ('37', '沈阳');
INSERT INTO `sys_city` VALUES ('38', '大连');
INSERT INTO `sys_city` VALUES ('39', '鞍山');
INSERT INTO `sys_city` VALUES ('40', '抚顺');
INSERT INTO `sys_city` VALUES ('41', '本溪');
INSERT INTO `sys_city` VALUES ('42', '丹东');
INSERT INTO `sys_city` VALUES ('43', '锦州');
INSERT INTO `sys_city` VALUES ('44', '营口');
INSERT INTO `sys_city` VALUES ('45', '阜新');
INSERT INTO `sys_city` VALUES ('46', '辽阳');
INSERT INTO `sys_city` VALUES ('47', '盘锦');
INSERT INTO `sys_city` VALUES ('48', '铁岭');
INSERT INTO `sys_city` VALUES ('49', '朝阳');
INSERT INTO `sys_city` VALUES ('50', '葫芦岛');
INSERT INTO `sys_city` VALUES ('51', '长春');
INSERT INTO `sys_city` VALUES ('52', '吉林');
INSERT INTO `sys_city` VALUES ('53', '四平');
INSERT INTO `sys_city` VALUES ('54', '辽源');
INSERT INTO `sys_city` VALUES ('55', '通化');
INSERT INTO `sys_city` VALUES ('56', '白山');
INSERT INTO `sys_city` VALUES ('57', '松原');
INSERT INTO `sys_city` VALUES ('58', '白城');
INSERT INTO `sys_city` VALUES ('59', '延边');
INSERT INTO `sys_city` VALUES ('60', '哈尔滨');
INSERT INTO `sys_city` VALUES ('61', '齐齐哈尔');
INSERT INTO `sys_city` VALUES ('62', '鸡西');
INSERT INTO `sys_city` VALUES ('63', '鹤岗');
INSERT INTO `sys_city` VALUES ('64', '双鸭山');
INSERT INTO `sys_city` VALUES ('65', '大庆');
INSERT INTO `sys_city` VALUES ('66', '伊春');
INSERT INTO `sys_city` VALUES ('67', '佳木斯');
INSERT INTO `sys_city` VALUES ('68', '七台河');
INSERT INTO `sys_city` VALUES ('69', '牡丹江');
INSERT INTO `sys_city` VALUES ('70', '黑河');
INSERT INTO `sys_city` VALUES ('71', '绥化');
INSERT INTO `sys_city` VALUES ('72', '大兴安岭');
INSERT INTO `sys_city` VALUES ('73', '上海');
INSERT INTO `sys_city` VALUES ('74', '南京');
INSERT INTO `sys_city` VALUES ('75', '无锡');
INSERT INTO `sys_city` VALUES ('76', '徐州');
INSERT INTO `sys_city` VALUES ('77', '常州');
INSERT INTO `sys_city` VALUES ('78', '苏州');
INSERT INTO `sys_city` VALUES ('79', '南通');
INSERT INTO `sys_city` VALUES ('80', '连云港');
INSERT INTO `sys_city` VALUES ('81', '淮安');
INSERT INTO `sys_city` VALUES ('82', '盐城');
INSERT INTO `sys_city` VALUES ('83', '扬州');
INSERT INTO `sys_city` VALUES ('84', '镇江');
INSERT INTO `sys_city` VALUES ('85', '泰州');
INSERT INTO `sys_city` VALUES ('86', '宿迁');
INSERT INTO `sys_city` VALUES ('87', '杭州');
INSERT INTO `sys_city` VALUES ('88', '宁波');
INSERT INTO `sys_city` VALUES ('89', '温州');
INSERT INTO `sys_city` VALUES ('90', '嘉兴');
INSERT INTO `sys_city` VALUES ('91', '湖州');
INSERT INTO `sys_city` VALUES ('92', '绍兴');
INSERT INTO `sys_city` VALUES ('93', '金华');
INSERT INTO `sys_city` VALUES ('94', '衢州');
INSERT INTO `sys_city` VALUES ('95', '舟山');
INSERT INTO `sys_city` VALUES ('96', '台州');
INSERT INTO `sys_city` VALUES ('97', '丽水');
INSERT INTO `sys_city` VALUES ('98', '合肥');
INSERT INTO `sys_city` VALUES ('99', '芜湖');
INSERT INTO `sys_city` VALUES ('100', '蚌埠');
INSERT INTO `sys_city` VALUES ('101', '淮南');
INSERT INTO `sys_city` VALUES ('102', '马鞍山');
INSERT INTO `sys_city` VALUES ('103', '淮北');
INSERT INTO `sys_city` VALUES ('104', '铜陵');
INSERT INTO `sys_city` VALUES ('105', '安庆');
INSERT INTO `sys_city` VALUES ('106', '黄山');
INSERT INTO `sys_city` VALUES ('107', '滁州');
INSERT INTO `sys_city` VALUES ('108', '阜阳');
INSERT INTO `sys_city` VALUES ('109', '宿州');
INSERT INTO `sys_city` VALUES ('110', '六安');
INSERT INTO `sys_city` VALUES ('111', '亳州');
INSERT INTO `sys_city` VALUES ('112', '池州');
INSERT INTO `sys_city` VALUES ('113', '宣城');
INSERT INTO `sys_city` VALUES ('114', '福州');
INSERT INTO `sys_city` VALUES ('115', '厦门');
INSERT INTO `sys_city` VALUES ('116', '莆田');
INSERT INTO `sys_city` VALUES ('117', '三明');
INSERT INTO `sys_city` VALUES ('118', '泉州');
INSERT INTO `sys_city` VALUES ('119', '漳州');
INSERT INTO `sys_city` VALUES ('120', '南平');
INSERT INTO `sys_city` VALUES ('121', '龙岩');
INSERT INTO `sys_city` VALUES ('122', '宁德');
INSERT INTO `sys_city` VALUES ('123', '南昌');
INSERT INTO `sys_city` VALUES ('124', '景德镇');
INSERT INTO `sys_city` VALUES ('125', '萍乡');
INSERT INTO `sys_city` VALUES ('126', '九江');
INSERT INTO `sys_city` VALUES ('127', '新余');
INSERT INTO `sys_city` VALUES ('128', '鹰潭');
INSERT INTO `sys_city` VALUES ('129', '赣州');
INSERT INTO `sys_city` VALUES ('130', '吉安');
INSERT INTO `sys_city` VALUES ('131', '宜春');
INSERT INTO `sys_city` VALUES ('132', '抚州');
INSERT INTO `sys_city` VALUES ('133', '上饶');
INSERT INTO `sys_city` VALUES ('134', '济南');
INSERT INTO `sys_city` VALUES ('135', '青岛');
INSERT INTO `sys_city` VALUES ('136', '淄博');
INSERT INTO `sys_city` VALUES ('137', '枣庄');
INSERT INTO `sys_city` VALUES ('138', '东营');
INSERT INTO `sys_city` VALUES ('139', '烟台');
INSERT INTO `sys_city` VALUES ('140', '潍坊');
INSERT INTO `sys_city` VALUES ('141', '济宁');
INSERT INTO `sys_city` VALUES ('142', '泰安');
INSERT INTO `sys_city` VALUES ('143', '威海');
INSERT INTO `sys_city` VALUES ('144', '日照');
INSERT INTO `sys_city` VALUES ('145', '莱芜');
INSERT INTO `sys_city` VALUES ('146', '临沂');
INSERT INTO `sys_city` VALUES ('147', '德州');
INSERT INTO `sys_city` VALUES ('148', '聊城');
INSERT INTO `sys_city` VALUES ('149', '滨州');
INSERT INTO `sys_city` VALUES ('150', '菏泽');
INSERT INTO `sys_city` VALUES ('151', '郑州');
INSERT INTO `sys_city` VALUES ('152', '开封');
INSERT INTO `sys_city` VALUES ('153', '洛阳');
INSERT INTO `sys_city` VALUES ('154', '平顶山');
INSERT INTO `sys_city` VALUES ('155', '安阳');
INSERT INTO `sys_city` VALUES ('156', '鹤壁');
INSERT INTO `sys_city` VALUES ('157', '新乡');
INSERT INTO `sys_city` VALUES ('158', '焦作');
INSERT INTO `sys_city` VALUES ('159', '濮阳');
INSERT INTO `sys_city` VALUES ('160', '许昌');
INSERT INTO `sys_city` VALUES ('161', '漯河');
INSERT INTO `sys_city` VALUES ('162', '三门峡');
INSERT INTO `sys_city` VALUES ('163', '南阳');
INSERT INTO `sys_city` VALUES ('164', '商丘');
INSERT INTO `sys_city` VALUES ('165', '信阳');
INSERT INTO `sys_city` VALUES ('166', '周口');
INSERT INTO `sys_city` VALUES ('167', '驻马店');
INSERT INTO `sys_city` VALUES ('168', '济源');
INSERT INTO `sys_city` VALUES ('169', '武汉');
INSERT INTO `sys_city` VALUES ('170', '黄石');
INSERT INTO `sys_city` VALUES ('171', '十堰');
INSERT INTO `sys_city` VALUES ('172', '宜昌');
INSERT INTO `sys_city` VALUES ('173', '襄阳');
INSERT INTO `sys_city` VALUES ('174', '鄂州');
INSERT INTO `sys_city` VALUES ('175', '荆门');
INSERT INTO `sys_city` VALUES ('176', '孝感');
INSERT INTO `sys_city` VALUES ('177', '荆州');
INSERT INTO `sys_city` VALUES ('178', '黄冈');
INSERT INTO `sys_city` VALUES ('179', '咸宁');
INSERT INTO `sys_city` VALUES ('180', '随州');
INSERT INTO `sys_city` VALUES ('181', '恩施');
INSERT INTO `sys_city` VALUES ('182', '仙桃');
INSERT INTO `sys_city` VALUES ('183', '潜江');
INSERT INTO `sys_city` VALUES ('184', '天门');
INSERT INTO `sys_city` VALUES ('185', '神农架林区');
INSERT INTO `sys_city` VALUES ('186', '长沙');
INSERT INTO `sys_city` VALUES ('187', '株洲');
INSERT INTO `sys_city` VALUES ('188', '湘潭');
INSERT INTO `sys_city` VALUES ('189', '衡阳');
INSERT INTO `sys_city` VALUES ('190', '邵阳');
INSERT INTO `sys_city` VALUES ('191', '岳阳');
INSERT INTO `sys_city` VALUES ('192', '常德');
INSERT INTO `sys_city` VALUES ('193', '张家界');
INSERT INTO `sys_city` VALUES ('194', '益阳');
INSERT INTO `sys_city` VALUES ('195', '郴州');
INSERT INTO `sys_city` VALUES ('196', '永州');
INSERT INTO `sys_city` VALUES ('197', '怀化');
INSERT INTO `sys_city` VALUES ('198', '娄底');
INSERT INTO `sys_city` VALUES ('199', '湘西');
INSERT INTO `sys_city` VALUES ('200', '广州');
INSERT INTO `sys_city` VALUES ('201', '韶关');
INSERT INTO `sys_city` VALUES ('202', '深圳');
INSERT INTO `sys_city` VALUES ('203', '珠海');
INSERT INTO `sys_city` VALUES ('204', '汕头');
INSERT INTO `sys_city` VALUES ('205', '佛山');
INSERT INTO `sys_city` VALUES ('206', '江门');
INSERT INTO `sys_city` VALUES ('207', '湛江');
INSERT INTO `sys_city` VALUES ('208', '茂名');
INSERT INTO `sys_city` VALUES ('209', '肇庆');
INSERT INTO `sys_city` VALUES ('210', '惠州');
INSERT INTO `sys_city` VALUES ('211', '梅州');
INSERT INTO `sys_city` VALUES ('212', '汕尾');
INSERT INTO `sys_city` VALUES ('213', '河源');
INSERT INTO `sys_city` VALUES ('214', '阳江');
INSERT INTO `sys_city` VALUES ('215', '清远');
INSERT INTO `sys_city` VALUES ('216', '东莞');
INSERT INTO `sys_city` VALUES ('217', '中山');
INSERT INTO `sys_city` VALUES ('218', '潮州');
INSERT INTO `sys_city` VALUES ('219', '揭阳');
INSERT INTO `sys_city` VALUES ('220', '云浮');
INSERT INTO `sys_city` VALUES ('221', '南宁');
INSERT INTO `sys_city` VALUES ('222', '柳州');
INSERT INTO `sys_city` VALUES ('223', '桂林');
INSERT INTO `sys_city` VALUES ('224', '梧州');
INSERT INTO `sys_city` VALUES ('225', '北海');
INSERT INTO `sys_city` VALUES ('226', '防城港');
INSERT INTO `sys_city` VALUES ('227', '钦州');
INSERT INTO `sys_city` VALUES ('228', '贵港');
INSERT INTO `sys_city` VALUES ('229', '玉林');
INSERT INTO `sys_city` VALUES ('230', '百色');
INSERT INTO `sys_city` VALUES ('231', '贺州');
INSERT INTO `sys_city` VALUES ('232', '河池');
INSERT INTO `sys_city` VALUES ('233', '来宾');
INSERT INTO `sys_city` VALUES ('234', '崇左');
INSERT INTO `sys_city` VALUES ('235', '海口');
INSERT INTO `sys_city` VALUES ('236', '三亚');
INSERT INTO `sys_city` VALUES ('237', '三沙');
INSERT INTO `sys_city` VALUES ('238', '儋州');
INSERT INTO `sys_city` VALUES ('239', '五指山');
INSERT INTO `sys_city` VALUES ('240', '琼海');
INSERT INTO `sys_city` VALUES ('241', '文昌');
INSERT INTO `sys_city` VALUES ('242', '万宁');
INSERT INTO `sys_city` VALUES ('243', '东方');
INSERT INTO `sys_city` VALUES ('244', '定安');
INSERT INTO `sys_city` VALUES ('245', '屯昌');
INSERT INTO `sys_city` VALUES ('246', '澄迈');
INSERT INTO `sys_city` VALUES ('247', '临高');
INSERT INTO `sys_city` VALUES ('248', '白沙');
INSERT INTO `sys_city` VALUES ('249', '昌江');
INSERT INTO `sys_city` VALUES ('250', '乐东');
INSERT INTO `sys_city` VALUES ('251', '陵水');
INSERT INTO `sys_city` VALUES ('252', '保亭');
INSERT INTO `sys_city` VALUES ('253', '琼中');
INSERT INTO `sys_city` VALUES ('254', '重庆');
INSERT INTO `sys_city` VALUES ('255', '成都');
INSERT INTO `sys_city` VALUES ('256', '自贡');
INSERT INTO `sys_city` VALUES ('257', '攀枝花');
INSERT INTO `sys_city` VALUES ('258', '泸州');
INSERT INTO `sys_city` VALUES ('259', '德阳');
INSERT INTO `sys_city` VALUES ('260', '绵阳');
INSERT INTO `sys_city` VALUES ('261', '广元');
INSERT INTO `sys_city` VALUES ('262', '遂宁');
INSERT INTO `sys_city` VALUES ('263', '内江');
INSERT INTO `sys_city` VALUES ('264', '乐山');
INSERT INTO `sys_city` VALUES ('265', '南充');
INSERT INTO `sys_city` VALUES ('266', '眉山');
INSERT INTO `sys_city` VALUES ('267', '宜宾');
INSERT INTO `sys_city` VALUES ('268', '广安');
INSERT INTO `sys_city` VALUES ('269', '达州');
INSERT INTO `sys_city` VALUES ('270', '雅安');
INSERT INTO `sys_city` VALUES ('271', '巴中');
INSERT INTO `sys_city` VALUES ('272', '资阳');
INSERT INTO `sys_city` VALUES ('273', '阿坝');
INSERT INTO `sys_city` VALUES ('274', '甘孜');
INSERT INTO `sys_city` VALUES ('275', '凉山');
INSERT INTO `sys_city` VALUES ('276', '贵阳');
INSERT INTO `sys_city` VALUES ('277', '六盘水');
INSERT INTO `sys_city` VALUES ('278', '遵义');
INSERT INTO `sys_city` VALUES ('279', '安顺');
INSERT INTO `sys_city` VALUES ('280', '毕节');
INSERT INTO `sys_city` VALUES ('281', '铜仁');
INSERT INTO `sys_city` VALUES ('282', '黔西南');
INSERT INTO `sys_city` VALUES ('283', '黔东南');
INSERT INTO `sys_city` VALUES ('284', '黔南');
INSERT INTO `sys_city` VALUES ('285', '昆明');
INSERT INTO `sys_city` VALUES ('286', '曲靖');
INSERT INTO `sys_city` VALUES ('287', '玉溪');
INSERT INTO `sys_city` VALUES ('288', '保山');
INSERT INTO `sys_city` VALUES ('289', '昭通');
INSERT INTO `sys_city` VALUES ('290', '丽江');
INSERT INTO `sys_city` VALUES ('291', '普洱');
INSERT INTO `sys_city` VALUES ('292', '临沧');
INSERT INTO `sys_city` VALUES ('293', '楚雄');
INSERT INTO `sys_city` VALUES ('294', '红河');
INSERT INTO `sys_city` VALUES ('295', '文山');
INSERT INTO `sys_city` VALUES ('296', '西双版纳');
INSERT INTO `sys_city` VALUES ('297', '大理');
INSERT INTO `sys_city` VALUES ('298', '德宏');
INSERT INTO `sys_city` VALUES ('299', '怒江');
INSERT INTO `sys_city` VALUES ('300', '迪庆');
INSERT INTO `sys_city` VALUES ('301', '拉萨');
INSERT INTO `sys_city` VALUES ('302', '日喀则');
INSERT INTO `sys_city` VALUES ('303', '昌都');
INSERT INTO `sys_city` VALUES ('304', '林芝');
INSERT INTO `sys_city` VALUES ('305', '山南');
INSERT INTO `sys_city` VALUES ('306', '那曲');
INSERT INTO `sys_city` VALUES ('307', '阿里');
INSERT INTO `sys_city` VALUES ('308', '西安');
INSERT INTO `sys_city` VALUES ('309', '铜川');
INSERT INTO `sys_city` VALUES ('310', '宝鸡');
INSERT INTO `sys_city` VALUES ('311', '咸阳');
INSERT INTO `sys_city` VALUES ('312', '渭南');
INSERT INTO `sys_city` VALUES ('313', '延安');
INSERT INTO `sys_city` VALUES ('314', '汉中');
INSERT INTO `sys_city` VALUES ('315', '榆林');
INSERT INTO `sys_city` VALUES ('316', '安康');
INSERT INTO `sys_city` VALUES ('317', '商洛');
INSERT INTO `sys_city` VALUES ('318', '兰州');
INSERT INTO `sys_city` VALUES ('319', '嘉峪关');
INSERT INTO `sys_city` VALUES ('320', '金昌');
INSERT INTO `sys_city` VALUES ('321', '白银');
INSERT INTO `sys_city` VALUES ('322', '天水');
INSERT INTO `sys_city` VALUES ('323', '武威');
INSERT INTO `sys_city` VALUES ('324', '张掖');
INSERT INTO `sys_city` VALUES ('325', '平凉');
INSERT INTO `sys_city` VALUES ('326', '酒泉');
INSERT INTO `sys_city` VALUES ('327', '庆阳');
INSERT INTO `sys_city` VALUES ('328', '定西');
INSERT INTO `sys_city` VALUES ('329', '陇南');
INSERT INTO `sys_city` VALUES ('330', '临夏');
INSERT INTO `sys_city` VALUES ('331', '甘南');
INSERT INTO `sys_city` VALUES ('332', '西宁');
INSERT INTO `sys_city` VALUES ('333', '海东');
INSERT INTO `sys_city` VALUES ('334', '海北');
INSERT INTO `sys_city` VALUES ('335', '黄南');
INSERT INTO `sys_city` VALUES ('336', '海南');
INSERT INTO `sys_city` VALUES ('337', '果洛');
INSERT INTO `sys_city` VALUES ('338', '玉树');
INSERT INTO `sys_city` VALUES ('339', '海西');
INSERT INTO `sys_city` VALUES ('340', '银川');
INSERT INTO `sys_city` VALUES ('341', '石嘴山');
INSERT INTO `sys_city` VALUES ('342', '吴忠');
INSERT INTO `sys_city` VALUES ('343', '固原');
INSERT INTO `sys_city` VALUES ('344', '中卫');
INSERT INTO `sys_city` VALUES ('345', '乌鲁木齐');
INSERT INTO `sys_city` VALUES ('346', '克拉玛依');
INSERT INTO `sys_city` VALUES ('347', '吐鲁番');
INSERT INTO `sys_city` VALUES ('348', '哈密');
INSERT INTO `sys_city` VALUES ('349', '昌吉');
INSERT INTO `sys_city` VALUES ('350', '博尔塔拉');
INSERT INTO `sys_city` VALUES ('351', '巴音郭楞');
INSERT INTO `sys_city` VALUES ('352', '阿克苏');
INSERT INTO `sys_city` VALUES ('353', '克孜勒苏');
INSERT INTO `sys_city` VALUES ('354', '喀什');
INSERT INTO `sys_city` VALUES ('355', '和田');
INSERT INTO `sys_city` VALUES ('356', '伊犁');
INSERT INTO `sys_city` VALUES ('357', '塔城');
INSERT INTO `sys_city` VALUES ('358', '阿勒泰');
INSERT INTO `sys_city` VALUES ('359', '石河子');
INSERT INTO `sys_city` VALUES ('360', '阿拉尔');
INSERT INTO `sys_city` VALUES ('361', '图木舒克');
INSERT INTO `sys_city` VALUES ('362', '五家渠');
INSERT INTO `sys_city` VALUES ('363', '北屯');
INSERT INTO `sys_city` VALUES ('364', '铁门关');
INSERT INTO `sys_city` VALUES ('365', '双河');
INSERT INTO `sys_city` VALUES ('366', '可克达拉');
INSERT INTO `sys_city` VALUES ('367', '昆玉');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `param_key` varchar(50) DEFAULT NULL COMMENT 'key',
  `param_value` varchar(2000) DEFAULT NULL COMMENT 'value',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态   0：隐藏   1：显示',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `param_key` (`param_key`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统配置信息表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('1', 'CLOUD_STORAGE_CONFIG_KEY', '{\"aliyunAccessKeyId\":\"\",\"aliyunAccessKeySecret\":\"\",\"aliyunBucketName\":\"\",\"aliyunDomain\":\"\",\"aliyunEndPoint\":\"\",\"aliyunPrefix\":\"\",\"qcloudBucketName\":\"\",\"qcloudDomain\":\"\",\"qcloudPrefix\":\"\",\"qcloudSecretId\":\"\",\"qcloudSecretKey\":\"\",\"qiniuAccessKey\":\"NrgMfABZxWLo5B-YYSjoE8-AZ1EISdi1Z3ubLOeZ\",\"qiniuBucketName\":\"ios-app\",\"qiniuDomain\":\"http://7xqbwh.dl1.z0.glb.clouddn.com\",\"qiniuPrefix\":\"upload\",\"qiniuSecretKey\":\"uIwJHevMRWU0VLxFvgy0tAcOdGqasdtVlJkdy6vV\",\"type\":1}', '0', '云存储配置信息');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上级部门ID，一级部门为0',
  `name` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='部门管理';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('1', '0', '人人开源集团', '0', '0');
INSERT INTO `sys_dept` VALUES ('2', '1', '长沙分公司', '1', '0');
INSERT INTO `sys_dept` VALUES ('3', '1', '上海分公司', '2', '0');
INSERT INTO `sys_dept` VALUES ('4', '3', '技术部', '0', '0');
INSERT INTO `sys_dept` VALUES ('5', '3', '销售部', '1', '0');

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '字典名称',
  `type` varchar(100) NOT NULL COMMENT '字典类型',
  `code` varchar(100) NOT NULL COMMENT '字典码',
  `value` varchar(1000) NOT NULL COMMENT '字典值',
  `order_num` int(11) DEFAULT '0' COMMENT '排序',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '删除标记  -1：已删除  0：正常',
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`,`code`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='数据字典表';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('1', '性别', 'sex', '0', '女', '0', null, '0');
INSERT INTO `sys_dict` VALUES ('2', '性别', 'sex', '1', '男', '1', null, '0');
INSERT INTO `sys_dict` VALUES ('3', '性别', 'sex', '2', '未知', '3', null, '0');
INSERT INTO `sys_dict` VALUES ('4', 'ddd', 'sting', '111', 'aaaa', '1', 'aaa', '0');
INSERT INTO `sys_dict` VALUES ('5', '123', '123', '123', '123', '1', '123', '0');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='系统日志';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1', 'admin', '保存角色', 'io.renren.modules.sys.controller.SysRoleController.save()', '{\"roleId\":1,\"roleName\":\"1\",\"remark\":\"111\",\"deptId\":4,\"deptName\":\"技术部\",\"menuIdList\":[],\"deptIdList\":[],\"createTime\":\"Dec 12, 2018 11:21:01 AM\"}', '125', '0:0:0:0:0:0:0:1', '2018-12-12 11:21:01');
INSERT INTO `sys_log` VALUES ('2', 'admin', '修改菜单', 'com.admin.modules.sys.controller.SysMenuController.update()', '{\"menuId\":52,\"parentId\":1,\"parentName\":\"系统管理\",\"name\":\"配送员管理\",\"url\":\"modules/sys/courier.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6}', '18', '0:0:0:0:0:0:0:1', '2018-12-30 10:13:08');
INSERT INTO `sys_log` VALUES ('3', 'admin', '修改菜单', 'com.admin.modules.sys.controller.SysMenuController.update()', '{\"menuId\":77,\"parentId\":1,\"parentName\":\"系统管理\",\"name\":\"ERP账号管理\",\"url\":\"modules/sys/erp.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6}', '21', '0:0:0:0:0:0:0:1', '2019-01-03 22:12:14');
INSERT INTO `sys_log` VALUES ('4', 'admin', '导出配送员信息', 'com.admin.modules.sys.controller.CourierController.exportCourier()', null, '370', '0:0:0:0:0:0:0:1', '2019-01-06 12:54:01');
INSERT INTO `sys_log` VALUES ('5', 'admin', '导出配送员信息', 'com.admin.modules.sys.controller.CourierController.exportCourier()', null, '24', '0:0:0:0:0:0:0:1', '2019-01-06 16:54:34');
INSERT INTO `sys_log` VALUES ('6', 'admin', '导出配送员信息', 'com.admin.modules.sys.controller.CourierController.exportCourier()', null, '22', '0:0:0:0:0:0:0:1', '2019-01-06 16:54:51');
INSERT INTO `sys_log` VALUES ('7', 'admin', '导出配送员信息', 'com.admin.modules.sys.controller.CourierController.exportCourier()', null, '17', '0:0:0:0:0:0:0:1', '2019-01-06 16:55:18');
INSERT INTO `sys_log` VALUES ('8', 'admin', '导入配送员信息', 'com.admin.modules.sys.controller.CourierController.importCourier()', '{\"part\":{\"fileItem\":{\"fieldName\":\"file\",\"contentType\":\"application/octet-stream\",\"isFormField\":false,\"fileName\":\"配送员信息模板.xlsx\",\"size\":-1,\"sizeThreshold\":0,\"repository\":{\"path\":\"C:\\\\Users\\\\chinda\\\\AppData\\\\Local\\\\Temp\\\\tomcat.778707974081828374.8099\\\\work\\\\Tomcat\\\\localhost\\\\admin\"},\"headers\":{\"headerNameToValueListMap\":{\"content-disposition\":[\"form-data; name\\u003d\\\"file\\\"; filename\\u003d\\\"配送员信息模板.xlsx\\\"\"],\"content-type\":[\"application/octet-stream\"]}},\"defaultCharset\":\"ISO-8859-1\"},\"location\":{\"path\":\"C:\\\\Users\\\\chinda\\\\AppData\\\\Local\\\\Temp\\\\tomcat.778707974081828374.8099\\\\work\\\\Tomcat\\\\localhost\\\\admin\"}},\"filename\":\"配送员信息模板.xlsx\"}', '416', '0:0:0:0:0:0:0:1', '2019-01-06 17:54:20');
INSERT INTO `sys_log` VALUES ('9', 'admin', '修改菜单', 'com.admin.modules.sys.controller.SysMenuController.update()', '{\"menuId\":92,\"parentId\":1,\"parentName\":\"系统管理\",\"name\":\"运营数据管理\",\"url\":\"modules/sys/dispatch.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6}', '19', '0:0:0:0:0:0:0:1', '2019-01-07 06:10:37');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '系统管理', null, null, '0', 'fa fa-cog', '0');
INSERT INTO `sys_menu` VALUES ('2', '1', '管理员管理', 'modules/sys/user.html', null, '1', 'fa fa-user', '1');
INSERT INTO `sys_menu` VALUES ('3', '1', '角色管理', 'modules/sys/role.html', null, '1', 'fa fa-user-secret', '2');
INSERT INTO `sys_menu` VALUES ('4', '1', '菜单管理', 'modules/sys/menu.html', null, '1', 'fa fa-th-list', '3');
INSERT INTO `sys_menu` VALUES ('5', '1', 'SQL监控', 'druid/sql.html', null, '1', 'fa fa-bug', '4');
INSERT INTO `sys_menu` VALUES ('6', '1', '定时任务', 'modules/job/schedule.html', null, '1', 'fa fa-tasks', '5');
INSERT INTO `sys_menu` VALUES ('7', '6', '查看', null, 'sys:schedule:list,sys:schedule:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('8', '6', '新增', null, 'sys:schedule:save', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('9', '6', '修改', null, 'sys:schedule:update', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('10', '6', '删除', null, 'sys:schedule:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('11', '6', '暂停', null, 'sys:schedule:pause', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('12', '6', '恢复', null, 'sys:schedule:resume', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('13', '6', '立即执行', null, 'sys:schedule:run', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('14', '6', '日志列表', null, 'sys:schedule:log', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('15', '2', '查看', null, 'sys:user:list,sys:user:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('16', '2', '新增', null, 'sys:user:save,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('17', '2', '修改', null, 'sys:user:update,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('18', '2', '删除', null, 'sys:user:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('19', '3', '查看', null, 'sys:role:list,sys:role:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('20', '3', '新增', null, 'sys:role:save,sys:menu:perms', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('21', '3', '修改', null, 'sys:role:update,sys:menu:perms', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('22', '3', '删除', null, 'sys:role:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('23', '4', '查看', null, 'sys:menu:list,sys:menu:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('24', '4', '新增', null, 'sys:menu:save,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('25', '4', '修改', null, 'sys:menu:update,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('26', '4', '删除', null, 'sys:menu:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('27', '1', '参数管理', 'modules/sys/config.html', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', '1', 'fa fa-sun-o', '6');
INSERT INTO `sys_menu` VALUES ('29', '1', '系统日志', 'modules/sys/log.html', 'sys:log:list', '1', 'fa fa-file-text-o', '7');
INSERT INTO `sys_menu` VALUES ('30', '1', '文件上传', 'modules/oss/oss.html', 'sys:oss:all', '1', 'fa fa-file-image-o', '6');
INSERT INTO `sys_menu` VALUES ('31', '1', '部门管理', 'modules/sys/dept.html', null, '1', 'fa fa-file-code-o', '1');
INSERT INTO `sys_menu` VALUES ('32', '31', '查看', null, 'sys:dept:list,sys:dept:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('33', '31', '新增', null, 'sys:dept:save,sys:dept:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('34', '31', '修改', null, 'sys:dept:update,sys:dept:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('35', '31', '删除', null, 'sys:dept:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('36', '1', '字典管理', 'modules/sys/dict.html', null, '1', 'fa fa-bookmark-o', '6');
INSERT INTO `sys_menu` VALUES ('37', '36', '查看', null, 'sys:dict:list,sys:dict:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('38', '36', '新增', null, 'sys:dict:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('39', '36', '修改', null, 'sys:dict:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('40', '36', '删除', null, 'sys:dict:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('41', '1', '合同管理', 'modules/sys/pact.html', '', '1', 'fa fa-file', '8');
INSERT INTO `sys_menu` VALUES ('42', '1', '城市信息表', 'modules/sys/cityinfo.html', null, '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('43', '42', '查看', null, 'sys:cityinfo:list,sys:cityinfo:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('44', '42', '新增', null, 'sys:cityinfo:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('45', '42', '修改', null, 'sys:cityinfo:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('46', '42', '删除', null, 'sys:cityinfo:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('47', '1', '公司信息表', 'modules/sys/companyinfo.html', null, '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('48', '47', '查看', null, 'sys:companyinfo:list,sys:companyinfo:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('49', '47', '新增', null, 'sys:companyinfo:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('50', '47', '修改', null, 'sys:companyinfo:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('51', '47', '删除', null, 'sys:companyinfo:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('52', '1', '配送员管理', 'modules/sys/courier.html', null, '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('53', '52', '查看', null, 'sys:courier:list,sys:courier:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('54', '52', '新增', null, 'sys:courier:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('55', '52', '修改', null, 'sys:courier:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('56', '52', '删除', null, 'sys:courier:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('57', '1', '配送信息表', 'modules/sys/dispatchinfo.html', null, '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('58', '57', '查看', null, 'sys:dispatchinfo:list,sys:dispatchinfo:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('59', '57', '新增', null, 'sys:dispatchinfo:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('60', '57', '修改', null, 'sys:dispatchinfo:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('61', '57', '删除', null, 'sys:dispatchinfo:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('62', '1', '合同信息表', 'modules/sys/pactinfo.html', null, '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('63', '62', '查看', null, 'sys:pactinfo:list,sys:pactinfo:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('64', '62', '新增', null, 'sys:pactinfo:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('65', '62', '修改', null, 'sys:pactinfo:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('66', '62', '删除', null, 'sys:pactinfo:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('67', '1', '片区表', 'modules/sys/area.html', null, '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('68', '67', '查看', null, 'sys:area:list,sys:area:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('69', '67', '新增', null, 'sys:area:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('70', '67', '修改', null, 'sys:area:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('71', '67', '删除', null, 'sys:area:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('72', '1', '城市信息表', 'modules/sys/city.html', null, '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('73', '72', '查看', null, 'sys:city:list,sys:city:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('74', '72', '新增', null, 'sys:city:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('75', '72', '修改', null, 'sys:city:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('76', '72', '删除', null, 'sys:city:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('77', '1', 'ERP账号管理', 'modules/sys/erp.html', null, '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('78', '77', '查看', null, 'sys:erp:list,sys:erp:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('79', '77', '新增', null, 'sys:erp:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('80', '77', '修改', null, 'sys:erp:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('81', '77', '删除', null, 'sys:erp:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('82', '1', '站点表', 'modules/sys/site.html', null, '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('83', '82', '查看', null, 'sys:site:list,sys:site:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('84', '82', '新增', null, 'sys:site:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('85', '82', '修改', null, 'sys:site:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('86', '82', '删除', null, 'sys:site:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('87', '1', '公司信息表', 'modules/sys/company.html', null, '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('88', '87', '查看', null, 'sys:company:list,sys:company:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('89', '87', '新增', null, 'sys:company:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('90', '87', '修改', null, 'sys:company:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('91', '87', '删除', null, 'sys:company:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('92', '1', '运营数据管理', 'modules/sys/dispatch.html', null, '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('93', '92', '查看', null, 'sys:dispatch:list,sys:dispatch:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('94', '92', '新增', null, 'sys:dispatch:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('95', '92', '修改', null, 'sys:dispatch:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('96', '92', '删除', null, 'sys:dispatch:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('97', '1', '合同信息表', 'modules/sys/pact.html', null, '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('98', '97', '查看', null, 'sys:pact:list,sys:pact:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('99', '97', '新增', null, 'sys:pact:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('100', '97', '修改', null, 'sys:pact:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('101', '97', '删除', null, 'sys:pact:delete', '2', null, '6');

-- ----------------------------
-- Table structure for sys_oss
-- ----------------------------
DROP TABLE IF EXISTS `sys_oss`;
CREATE TABLE `sys_oss` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) DEFAULT NULL COMMENT 'URL地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件上传';

-- ----------------------------
-- Records of sys_oss
-- ----------------------------

-- ----------------------------
-- Table structure for sys_pact_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_pact_file`;
CREATE TABLE `sys_pact_file` (
  `file_id` int(20) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`file_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_pact_file
-- ----------------------------

-- ----------------------------
-- Table structure for sys_pact_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_pact_info`;
CREATE TABLE `sys_pact_info` (
  `pact_id` int(20) NOT NULL AUTO_INCREMENT,
  `pact_name` varchar(255) DEFAULT NULL,
  `business_id` tinyint(3) DEFAULT NULL,
  `city_id` int(20) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_user_id` int(20) DEFAULT NULL,
  `pact_status` tinyint(3) DEFAULT NULL COMMENT '合同状态',
  `file_id` int(20) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `is_delete` tinyint(3) DEFAULT NULL,
  PRIMARY KEY (`pact_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_pact_info
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '1', '111', '4', '2018-12-12 11:21:01');

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与部门对应关系';

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) DEFAULT NULL COMMENT '盐',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'e1153123d7d180ceeb820d577ff119876678732a68eef4e6ffc0b1f06a01f91b', 'YzcmCZNvbXocrsz9dm8e', 'root@renren.io', '13612345678', '1', '1', '2016-11-11 11:11:11');
INSERT INTO `sys_user` VALUES ('2', 'admin2', 'e1153123d7d180ceeb820d577ff119876678732a68eef4e6ffc0b1f06a01f91b', 'YzcmCZNvbXocrsz9dm8e', 'root@renren.io', '13612345678', '1', '1', '2016-11-11 11:11:11');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for tb_area
-- ----------------------------
DROP TABLE IF EXISTS `tb_area`;
CREATE TABLE `tb_area` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `company_id` int(20) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `is_delete` int(1) DEFAULT '0' COMMENT '1:删除0:正常',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='片区表';

-- ----------------------------
-- Records of tb_area
-- ----------------------------
INSERT INTO `tb_area` VALUES ('4', '东北大区', '3', '2019-01-06 13:02:59', '0');

-- ----------------------------
-- Table structure for tb_city
-- ----------------------------
DROP TABLE IF EXISTS `tb_city`;
CREATE TABLE `tb_city` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `company_id` int(20) DEFAULT NULL,
  `area_id` int(20) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `is_delete` int(1) DEFAULT '0' COMMENT '1:删除0:正常',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='城市信息表';

-- ----------------------------
-- Records of tb_city
-- ----------------------------
INSERT INTO `tb_city` VALUES ('4', '大连市', '3', '4', '2019-01-06 13:03:37', '0');

-- ----------------------------
-- Table structure for tb_city_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_city_info`;
CREATE TABLE `tb_city_info` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='城市信息表';

-- ----------------------------
-- Records of tb_city_info
-- ----------------------------
INSERT INTO `tb_city_info` VALUES ('1', 'qq');

-- ----------------------------
-- Table structure for tb_company
-- ----------------------------
DROP TABLE IF EXISTS `tb_company`;
CREATE TABLE `tb_company` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(55) DEFAULT NULL COMMENT '公司名',
  `legal_person_name` varchar(50) DEFAULT NULL COMMENT '法人',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `zip_code` varchar(20) DEFAULT NULL COMMENT '邮编',
  `contact_name` varchar(50) DEFAULT NULL COMMENT '联系人',
  `phone` varchar(55) DEFAULT NULL COMMENT '联系人电话',
  `business_fileid` varchar(255) DEFAULT NULL COMMENT '营业执照',
  `card_fileid` varchar(255) DEFAULT NULL COMMENT '法人身份证',
  `province_name` varchar(255) DEFAULT NULL COMMENT '省份',
  `city_name` varchar(255) DEFAULT NULL COMMENT '城市',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `is_delete` int(1) DEFAULT '0' COMMENT '1:删除0:正常',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='公司信息表';

-- ----------------------------
-- Records of tb_company
-- ----------------------------
INSERT INTO `tb_company` VALUES ('3', '三方集团', '李日明', '大连市星海广场', 'lrm@163.com', '125630', '李日明', '15998988899', null, null, '辽宁', '大连', '2019-01-06 13:01:43', '0');

-- ----------------------------
-- Table structure for tb_company_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_company_info`;
CREATE TABLE `tb_company_info` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(55) DEFAULT NULL,
  `city_id` int(20) DEFAULT NULL,
  `legal_person_name` varchar(50) DEFAULT NULL COMMENT '法人',
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `zip_code` varchar(20) DEFAULT NULL COMMENT '邮编',
  `contact_name` varchar(50) DEFAULT NULL,
  `phone` varchar(55) DEFAULT NULL,
  `business_fileid` varchar(255) DEFAULT NULL,
  `card_fileid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='公司信息表';

-- ----------------------------
-- Records of tb_company_info
-- ----------------------------

-- ----------------------------
-- Table structure for tb_courier
-- ----------------------------
DROP TABLE IF EXISTS `tb_courier`;
CREATE TABLE `tb_courier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(55) NOT NULL COMMENT '快递员姓名',
  `card_id` varchar(50) DEFAULT NULL COMMENT '身份证',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话号',
  `bank_card_id` varchar(50) DEFAULT NULL COMMENT '银行卡号',
  `deposit_bank` varchar(255) DEFAULT NULL COMMENT '开户行名称',
  `join_bank_number` varchar(60) DEFAULT NULL COMMENT '银联号',
  `entry_date` datetime DEFAULT NULL COMMENT '入职时间',
  `leave_date` datetime DEFAULT NULL COMMENT '离职时间',
  `status` int(1) DEFAULT '0' COMMENT '1离职 0在职',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `company_id` int(20) DEFAULT NULL COMMENT '公司id',
  `pact_id` int(11) DEFAULT NULL COMMENT '合同id',
  `erp_id` int(20) DEFAULT NULL COMMENT 'ERP账号id',
  `area_id` int(20) DEFAULT NULL COMMENT '片区id',
  `city_id` int(11) DEFAULT NULL COMMENT '城市id',
  `site_id` int(20) DEFAULT NULL COMMENT '站点id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `is_delete` int(1) DEFAULT '0' COMMENT '1:删除0:正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COMMENT='快递员信息表';

-- ----------------------------
-- Records of tb_courier
-- ----------------------------
INSERT INTO `tb_courier` VALUES ('9', '李日明', '211111111111111111', '11111111111', '1111111111111111111', null, '222222222', '2019-01-06 00:00:00', '2019-01-27 00:00:00', '0', '我就一备注', '3', '12', '138', '4', '4', '2', '2019-01-06 13:11:51', '0');
INSERT INTO `tb_courier` VALUES ('10', '冷', '211422111111111008', '11111111111', '111111111111111', '工商', '125356', '2018-10-20 00:00:00', '2020-12-12 00:00:00', '0', '我就是一个备注', '3', '12', null, null, null, null, '2019-01-06 17:54:20', '0');

-- ----------------------------
-- Table structure for tb_dispatch
-- ----------------------------
DROP TABLE IF EXISTS `tb_dispatch`;
CREATE TABLE `tb_dispatch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `month` varchar(30) DEFAULT NULL COMMENT '月份',
  `erp_id` int(20) NOT NULL COMMENT '配送员ERP账号id',
  `all_order_count` int(20) DEFAULT NULL COMMENT '总单量',
  `total_order_count` int(20) DEFAULT NULL COMMENT '合计单量',
  `total_money` decimal(10,2) DEFAULT NULL COMMENT '费用合计',
  `small` int(20) DEFAULT NULL COMMENT '小件',
  `large` int(20) DEFAULT NULL COMMENT '大件',
  `thr_identical` int(20) DEFAULT NULL COMMENT '三同',
  `after_sale_count` int(20) DEFAULT NULL COMMENT '售后取件',
  `first_count` int(20) DEFAULT NULL COMMENT '接货首单量',
  `again_count` int(20) DEFAULT NULL COMMENT '接货续单量',
  `other_count` int(20) DEFAULT NULL COMMENT '其他单量',
  `bad_count` int(20) DEFAULT NULL COMMENT '差评数',
  `complaint_count` int(20) DEFAULT NULL COMMENT '投诉数',
  `fine_money` decimal(10,2) DEFAULT NULL COMMENT '罚款合计',
  `deduct_money` decimal(10,2) DEFAULT NULL COMMENT '其他扣款',
  `salary` decimal(10,2) DEFAULT NULL COMMENT '工资',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `is_delete` int(1) DEFAULT NULL COMMENT '1:删除0:正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COMMENT='配送信息表';

-- ----------------------------
-- Records of tb_dispatch
-- ----------------------------
INSERT INTO `tb_dispatch` VALUES ('1', '3', '11111', '45', '60', null, '22', '44', '9', '10', null, null, null, null, null, null, '11.11', '50.00', null, null, '0');
INSERT INTO `tb_dispatch` VALUES ('2', '2018-03', '22222', '60', '41', null, '12', '55', '0', '84', null, null, null, null, null, null, '11.11', '60.45', 'wqwq', null, '0');
INSERT INTO `tb_dispatch` VALUES ('3', '3', '33333', '45', '60', '55.66', '22', '44', '9', '10', '20', null, '60', null, null, null, '11.11', '50.23', null, null, '0');
INSERT INTO `tb_dispatch` VALUES ('4', '2018-03', '44444', '60', '41', '11.22', '12', '55', '0', '84', '10', '5', '6', '61', '4', '44.66', '11.11', '60.66', 'wqwq', null, '0');
INSERT INTO `tb_dispatch` VALUES ('5', '2018-03', '55555', '60', '41', '33.00', '12', '55', '0', '84', '4', '45', '7', '2', '1', '45.00', '11.11', '60.00', 'wqwq', null, '0');
INSERT INTO `tb_dispatch` VALUES ('6', '2018-03', '44444', '60', '41', '11.22', '12', '55', '0', '84', '10', '5', '6', '61', '4', '44.66', '11.11', '60.66', 'wqwq', null, '0');
INSERT INTO `tb_dispatch` VALUES ('7', '2018-03', '55555', '60', '41', '33.00', '12', '55', '0', '84', '4', '45', '7', '2', '1', '45.00', '11.11', '60.00', 'wqwq', null, '0');

-- ----------------------------
-- Table structure for tb_dispatch_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_dispatch_info`;
CREATE TABLE `tb_dispatch_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `month` varchar(30) DEFAULT NULL COMMENT '月份',
  `area` varchar(255) DEFAULT NULL COMMENT '片区',
  `city_name` varchar(255) DEFAULT NULL COMMENT '城市',
  `site` varchar(255) DEFAULT NULL COMMENT '站点',
  `erp_id` varchar(55) DEFAULT NULL COMMENT 'ERP账号',
  `courier_name` varchar(255) DEFAULT NULL COMMENT '配送员姓名',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `all_order_total` int(20) DEFAULT NULL,
  `count_order_total` int(20) DEFAULT NULL,
  `total_money` decimal(10,2) DEFAULT NULL,
  `small` int(255) DEFAULT NULL,
  `large` int(255) DEFAULT NULL COMMENT '大件',
  `thr_identical` varchar(255) DEFAULT NULL COMMENT '三同',
  `after_sale` varchar(255) DEFAULT NULL COMMENT '售后取件',
  `first_count` int(20) DEFAULT NULL,
  `again_count` int(20) DEFAULT NULL,
  `other_count` int(20) DEFAULT NULL,
  `bad_count` int(20) DEFAULT NULL,
  `complaint_count` int(20) DEFAULT NULL,
  `fine_money` decimal(10,2) DEFAULT NULL,
  `deduct_money` decimal(10,2) DEFAULT NULL COMMENT '扣钱',
  `salary` decimal(10,2) DEFAULT NULL COMMENT '工资',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COMMENT='配送信息表';

-- ----------------------------
-- Records of tb_dispatch_info
-- ----------------------------
INSERT INTO `tb_dispatch_info` VALUES ('1', '3', '片区1', '城市1', '站点1', '11111', '配送员1', null, '45', '60', null, '22', '44', '9', '10', null, null, null, null, null, null, '11.11', '50.00');
INSERT INTO `tb_dispatch_info` VALUES ('2', '2018-03', '片区2', '城市2', '站点2', '22222', '配送员2', 'wqwq', '60', '41', null, '12', '55', 'df', '84', null, null, null, null, null, null, '11.11', '60.45');
INSERT INTO `tb_dispatch_info` VALUES ('3', '3', '片区3', '城市3', '站点3', '33333', '配送员3', null, '45', '60', '55.66', '22', '44', '9', '10', '20', null, '60', null, null, null, '11.11', '50.23');
INSERT INTO `tb_dispatch_info` VALUES ('4', '2018-03', '片区4', '城市4', '站点4', '44444', '配送员4', 'wqwq', '60', '41', '11.22', '12', '55', 'df', '84', '10', '5', '6', '61', '4', '44.66', '11.11', '60.66');
INSERT INTO `tb_dispatch_info` VALUES ('5', '2018-03', '片区5', '城市5', '站点5', '55555', '配送员5', 'wqwq', '60', '41', '33.00', '12', '55', 'df', '84', '4', '45', '7', '2', '1', '45.00', '11.11', '60.00');
INSERT INTO `tb_dispatch_info` VALUES ('6', '2018-03', '片区4', '城市4', '站点4', '44444', '配送员4', 'wqwq', '60', '41', '11.22', '12', '55', 'df', '84', '10', '5', '6', '61', '4', '44.66', '11.11', '60.66');
INSERT INTO `tb_dispatch_info` VALUES ('7', '2018-03', '片区5', '城市5', '站点5', '55555', '配送员5', 'wqwq', '60', '41', '33.00', '12', '55', 'df', '84', '4', '45', '7', '2', '1', '45.00', '11.11', '60.00');

-- ----------------------------
-- Table structure for tb_erp
-- ----------------------------
DROP TABLE IF EXISTS `tb_erp`;
CREATE TABLE `tb_erp` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `erp_number` varchar(255) DEFAULT NULL,
  `company_id` int(20) DEFAULT NULL,
  `status` tinyint(3) DEFAULT '0' COMMENT '0启用1停用',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `is_delete` int(1) DEFAULT '0' COMMENT '1:删除0:正常',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=142 DEFAULT CHARSET=utf8 COMMENT='erp账号表';

-- ----------------------------
-- Records of tb_erp
-- ----------------------------
INSERT INTO `tb_erp` VALUES ('138', '12580', '3', '0', '2019-01-06 13:10:18', '0');
INSERT INTO `tb_erp` VALUES ('139', '12306', '3', '0', '2019-01-06 13:10:29', '0');
INSERT INTO `tb_erp` VALUES ('140', '15865', '3', '0', '2019-01-06 13:12:59', '0');
INSERT INTO `tb_erp` VALUES ('141', '24895', '3', '0', '2019-01-06 13:18:57', '0');

-- ----------------------------
-- Table structure for tb_pact
-- ----------------------------
DROP TABLE IF EXISTS `tb_pact`;
CREATE TABLE `tb_pact` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '合同名称',
  `business_name` varchar(255) DEFAULT NULL COMMENT '业务名称',
  `city_id` int(20) DEFAULT NULL,
  `start_date` date DEFAULT NULL COMMENT '开始时间',
  `end_date` date DEFAULT NULL COMMENT '结束时间',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `file_id` varchar(255) DEFAULT NULL COMMENT '合同文件id',
  `file_name` varchar(255) DEFAULT NULL,
  `company_id` int(20) DEFAULT NULL COMMENT '公司id',
  `province_name` varchar(255) DEFAULT NULL COMMENT '省份',
  `city_name` varchar(255) DEFAULT NULL COMMENT '城市',
  `is_delete` int(1) DEFAULT '0' COMMENT '1:删除0:正常',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='合同信息表';

-- ----------------------------
-- Records of tb_pact
-- ----------------------------
INSERT INTO `tb_pact` VALUES ('12', '两性对接协议', '卖淫合法化', '4', '2019-01-06', '2019-01-31', '2019-01-06 05:06:37', '', '两性协议', '3', '辽宁省', '大连市', '0');

-- ----------------------------
-- Table structure for tb_pact_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_pact_info`;
CREATE TABLE `tb_pact_info` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `business_name` varchar(255) DEFAULT NULL,
  `city_id` int(20) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `pact_status` tinyint(3) DEFAULT NULL,
  `file_id` varchar(255) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `is_delete` tinyint(3) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='合同信息表';

-- ----------------------------
-- Records of tb_pact_info
-- ----------------------------

-- ----------------------------
-- Table structure for tb_site
-- ----------------------------
DROP TABLE IF EXISTS `tb_site`;
CREATE TABLE `tb_site` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `company_id` int(20) DEFAULT NULL,
  `area_id` int(20) DEFAULT NULL,
  `city_id` int(20) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `is_delete` int(1) DEFAULT '0' COMMENT '1:删除0:正常',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='站点表';

-- ----------------------------
-- Records of tb_site
-- ----------------------------
INSERT INTO `tb_site` VALUES ('2', '河口站点', '3', '4', '4', '2019-01-06 13:04:00', '0');
