//
//  FirstViewController.swift
//  DashBoardApp
//
//  Created by Ilkay Tevfik Devran on 30.04.2018.
//  Copyright © 2018 ilkay_Devran. All rights reserved.
//

import UIKit
import Firebase
import FirebaseAuth
import Charts

class FirstViewController: UIViewController {

    @IBOutlet weak var pieChart: PieChartView!
    
    // Chart Items
    var seventyCl = PieChartDataEntry(value: 0)
    var thirtyFiveCl = PieChartDataEntry(value: 0)
    var glass = PieChartDataEntry(value: 0)
    var smoke = PieChartDataEntry(value: 0)
    var studentTicket = PieChartDataEntry(value: 0)
    var adultTicket = PieChartDataEntry(value: 0)
    var confetti = PieChartDataEntry(value: 0)
    
    var numberOfDownloadsDataEntries = [PieChartDataEntry]()
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        initPieChart()
        setItemsForChart()
        updateChartData()
    }
    
    // Set item values for first run
    func setItemsForChart(){
        seventyCl.value = 30
        seventyCl.label = "70cl"
        thirtyFiveCl.value = 60
        thirtyFiveCl.label = "35cl"
        glass.value = 40
        glass.label = "Bardak"
        smoke.value = 5
        smoke.label = "Sigara/Paket"
        studentTicket.value = 50
        studentTicket.label = "Bilet Öğrenci"
        adultTicket.value = 20
        adultTicket.label = "Bilet Tam"
        confetti.value = 10
        confetti.label = "Konfeti"
        
        numberOfDownloadsDataEntries = [seventyCl, thirtyFiveCl, glass, smoke, studentTicket, adultTicket, confetti]
    }
    
    // Set PieChartView properties
    func initPieChart(){
        pieChart.backgroundColor = UIColor(named:"pieChartBackground")
        pieChart.holeColor = UIColor(named:"pieChartBackground")
        pieChart.noDataText = "No date to display"
        pieChart.chartDescription?.text = ""
        pieChart.centerText = "Ciro Dağılımı"
        pieChart.drawEntryLabelsEnabled = false
        pieChart.layer.cornerRadius = 10  // didn't work :(
        //pieChart.drawHoleEnabled = false
        pieChart.animate(xAxisDuration: 2.0, yAxisDuration: 2.0/*, easingOption: .easeInCirc*/)
    }
    
    func updateChartData() {
        let chartDataSet = PieChartDataSet(values: numberOfDownloadsDataEntries, label: nil)
        let chartData = PieChartData(dataSet: chartDataSet)
        
        let colors = [UIColor(named:"seventyCl"), UIColor(named:"thirtyFiveCl"), UIColor(named:"glass"), UIColor(named:"smoke"), UIColor(named:"studentTicket"), UIColor(named:"adultTicket"), UIColor(named:"confetti")]
        chartDataSet.colors = colors as! [NSUIColor]//ChartColorTemplates.pastel()
        
        pieChart.data = chartData
        
        
    }
    
    // LogOut button performes
    @IBAction func logOutButtonClicked(_ sender: Any) {
        UserDefaults.standard.removeObject(forKey: "user")
        UserDefaults.standard.synchronize()
        
        let logIn = self.storyboard?.instantiateViewController(withIdentifier: "logInVC") as! logInVC
        let delegate : AppDelegate = UIApplication.shared.delegate as! AppDelegate
        delegate.window?.rootViewController = logIn
        
        delegate.rememberLogin()
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

