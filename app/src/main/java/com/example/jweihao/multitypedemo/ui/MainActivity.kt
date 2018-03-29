package com.example.jweihao.multitypedemo.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import com.example.jweihao.multitypedemo.R
import com.example.jweihao.multitypedemo.bean.App
import com.example.jweihao.multitypedemo.bean.AppList
import com.example.jweihao.multitypedemo.bean.Bank
import com.example.jweihao.multitypedemo.bean.BankList
import com.example.jweihao.multitypedemo.bean.Column
import com.example.jweihao.multitypedemo.bean.Label
import com.example.jweihao.multitypedemo.bean.LabelList
import com.example.jweihao.multitypedemo.bean.Logo
import com.example.jweihao.multitypedemo.viewbinder.LogoItemViewBinder
import com.example.jweihao.multitypedemo.viewbinder.BankListItemViewBinder
import com.example.jweihao.multitypedemo.viewbinder.AppListItemViewBinder
import com.example.jweihao.multitypedemo.viewbinder.ColumnItemViewBinder
import com.example.jweihao.multitypedemo.viewbinder.LabelListItemViewBinder

import java.util.ArrayList

import me.drakeet.multitype.Items
import me.drakeet.multitype.MultiTypeAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mMultiTypeAdapter: MultiTypeAdapter? = null
    private val mItems = Items()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //初始化控件，并设置LayoutManger
        initView()
        //注册类型和View的对应关系
        initRegister()
        //初始化数据
        initData()
    }

    private fun initView() {
//        mRecyclerView = findViewById<View>(R.id.recyclerview)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerview!!.layoutManager = layoutManager
    }

    private fun initRegister() {
        //      RecyclerView嵌套RecyclerView,水平滑动，只需提供数据bean，初始化布局ItemViewBinder即可。
        //      mMultiTypeAdapter.register(ObjectList.class, new HorizontalItemViewBinder(Label.class,new LabelItemViewBinder()));
        mMultiTypeAdapter = MultiTypeAdapter()
        mMultiTypeAdapter!!.register(LabelList::class.java!!, LabelListItemViewBinder())
        mMultiTypeAdapter!!.register(Column::class.java!!, ColumnItemViewBinder())
        mMultiTypeAdapter!!.register(BankList::class.java!!, BankListItemViewBinder())
        mMultiTypeAdapter!!.register(AppList::class.java!!, AppListItemViewBinder())
        mMultiTypeAdapter!!.register(Logo::class.java!!, LogoItemViewBinder())
        recyclerview!!.adapter = mMultiTypeAdapter
    }

    private fun initData() {
        //标签数据
        val labelList = ArrayList<Label>()
        labelList.add(Label("排行榜"))
        labelList.add(Label("游戏"))
        labelList.add(Label("类别"))
        labelList.add(Label("家庭"))
        labelList.add(Label("抢先体验"))
        labelList.add(Label("编辑精选"))
        labelList.add(Label("付费内容"))
        mItems.add(LabelList(labelList))

        //值得一试的应用，标题栏
        mItems.add(Column(
                R.drawable.shape_red_rectangles,
                "值得一试的应用",
                "更多",
                R.mipmap.tv_right
        ))

        //值得一试的应用，数据
        val bankList = ArrayList<Bank>()
        bankList.add(Bank(R.drawable.bank_abc, "ABC农业银行", "5.0"))
        bankList.add(Bank(R.drawable.bank_china_minsheng_banking, "中国民生银行", "3.5"))
        bankList.add(Bank(R.drawable.bank_china_guangfa_bank, "GuangFaBank", "4.7"))
        bankList.add(Bank(R.drawable.bank_china_merchants_bank, "MerchantsBank", "4.2"))
        bankList.add(Bank(R.drawable.bank_china_constuction_bank, "ConstuctionBank", "3.1"))
        bankList.add(Bank(R.drawable.bank_china_post, "中国邮政银行", "4.3"))
        bankList.add(Bank(R.drawable.bank_czbank, "CZBANK", "3.6"))
        bankList.add(Bank(R.drawable.bank_of_beijing, "BeiJingBank", "1.9"))
        bankList.add(Bank(R.drawable.bank_of_china, "ChinaBank", "2.4"))
        bankList.add(Bank(R.drawable.bank_pboc, "PBOC", "4.2"))
        mItems.add(BankList(bankList))


        //专门为您推荐，标题栏
        mItems.add(Column(
                R.drawable.shape_red_rectangles,
                "专门为您推荐",
                "更多",
                R.mipmap.tv_right
        ))

        //专门为您推荐，数据
        val appList1 = ArrayList<App>()
        appList1.add(App(R.drawable.icon_weibo, "WeiBo", "4.5"))
        appList1.add(App(R.drawable.icon_twitter, "Twitter", "3.9"))
        appList1.add(App(R.drawable.icon_wechat, "WeChat", "1.7"))
        appList1.add(App(R.drawable.icon_qq, "QQ", "2.9"))
        appList1.add(App(R.drawable.icon_alipay, "AliPay", "3.6"))
        appList1.add(App(R.drawable.icon_facebook, "FaceBook", "4.8"))
        appList1.add(App(R.drawable.icon_qzone, "QZone", "1.6"))
        appList1.add(App(R.drawable.icon_ins, "Instagram", "3.7"))
        appList1.add(App(R.drawable.icon_momo, "MOMO", "2.9"))
        appList1.add(App(R.drawable.icon_mixi, "MiXi", "4.3"))
        appList1.add(App(R.drawable.icon_linkedin, "Linkedin", "5.0"))
        appList1.add(App(R.drawable.icon_line, "Line", "3.2"))
        appList1.add(App(R.drawable.icon_github, "GitHub", "4.0"))
        appList1.add(App(R.drawable.icon_csdn, "CSDN", "3.8"))
        appList1.add(App(R.drawable.icon_google, "Google+", "4.1"))
        appList1.add(App(R.drawable.icon_pinterest, "Pinterest", "4.6"))
        appList1.add(App(R.drawable.icon_pixiv, "Pixiv", "2.4"))
        appList1.add(App(R.drawable.icon_renren, "Renren", "3.2"))
        appList1.add(App(R.drawable.icon_skype, "Skype", "4.9"))
        appList1.add(App(R.drawable.icon_tumblr, "Tumblr", "3.9"))
        appList1.add(App(R.drawable.icon_wechat_friend, "Wechat-Friend", "2.1"))
        appList1.add(App(R.drawable.icon_vk, "VK", "1.3"))
        appList1.add(App(R.drawable.icon_xiaoenai, "XiaoEnAi", "2.2"))
        mItems.add(AppList(appList1))


        //根据您的近期活动，标题栏
        mItems.add(Column(
                R.drawable.shape_red_rectangles,
                "根据您的近期活动",
                "更多",
                R.mipmap.tv_right
        ))
        //根据您的近期活动，数据
        mItems.add(Logo(R.drawable.logo_amazon_kindle, "Amazon_Kindle", "4.5"))
        mItems.add(Logo(R.drawable.logo_atlassian, "Atlassian", "3.5"))
        mItems.add(Logo(R.drawable.logo_creative_market, "Creative_Market", "2.8"))
        mItems.add(Logo(R.drawable.logo_invision, "Invision+", "4.9"))
        mItems.add(Logo(R.drawable.logo_prezi, "Prezi", "3.2"))
        mItems.add(Logo(R.drawable.logo_linkedin, "Linkedin", "2.1"))
        mItems.add(Logo(R.drawable.logo_skillshare, "Skillshare", "1.7"))
        mItems.add(Logo(R.drawable.logo_twitch, "Twitch", "3.5"))
        mItems.add(Logo(R.drawable.logo_variety, "Variety", "4.6"))
        mItems.add(Logo(R.drawable.logo_deezer, "Deezer", "2.6"))
        mItems.add(Logo(R.drawable.logo_youtube, "YouTube", "4.7"))

        //Adapter赋值
        mMultiTypeAdapter!!.items = mItems
        //刷新
        mMultiTypeAdapter!!.notifyDataSetChanged()
    }
}
