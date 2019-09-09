//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function () {
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse){
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }
  },
  getUserInfo: function(e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  },
  /*
  scanCode: function () {
    // 允许从相机和相册扫码
    wx.scanCode({
      success(res) {
        console.log(res)
      }
    })
  }*/

  
  // 微信小程序可以通过以下代码获取上述值： 
  scanCode: function () {
    var self = this;
    wx.scanCode({
      success: (res) => {
        if (res.scanType == 'QR_CODE') {
          //发起网络请求
          wx.request({
            url: 'http://127.0.0.1:8080/wx/QRData',
            data: {
              code: res.result,
              date: new Date()
            },
            method: 'POST',
            //不加header这条，Post数据服务器收不到内容
            header: { 'content-type': 'application/x-www-form-urlencoded' },
            success: res => {
              Console.log(JSON.stringify(res));
            },
            fail: res => {
              Console.log(res.data);
            }
            /*
          //"01,10,050003523456,29342181,104.72,20180613,02418567008427471889,1774," 
          console.log(res.result);
          var words = res.result.split(',');

          this.setData({
            firstUndefined:words[0],
            Invoicetype: words[1],
            InvoiceCode: words[2],
            InvoiceNumber: words[3],
            Amount:words[4],
            DateIssued: words[5],
            InvoiceVerifyCode: words[6],
            //unknown:words

            


            //scanCodeMsg: res.result
            */
          })
        } else {
          wx.showToast({
            title: '二维码信息无效',
            icon: 'none',
            duration: 2000
          });
        }
      },
      fail: (res) => {
        console.log(res);
        wx.showToast({
          title: '二维码信息无效',
          icon: 'none',
          duration: 2000
        });
      }
    })
  }
})
