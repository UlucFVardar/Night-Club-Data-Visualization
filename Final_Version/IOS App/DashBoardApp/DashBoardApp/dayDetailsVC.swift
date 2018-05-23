//
//  dayDetailsVC.swift
//  DashBoardApp
//
//  Created by Ilkay Tevfik Devran on 1.05.2018.
//  Copyright © 2018 ilkay_Devran. All rights reserved.
//

import UIKit
import Charts

class dayDetailsVC: UIViewController {
    
    @IBOutlet weak var hiUserLabel: UILabel!
    @IBOutlet weak var dateLabel: NSLayoutConstraint!
    @IBOutlet weak var artistLabel: UILabel!
    @IBOutlet weak var endorsementLabel: UILabel!
    @IBOutlet weak var commentTextField: UITextView!
    
    @IBOutlet weak var pieChart: PieChartView!
    @IBOutlet weak var barChart: BarChartView!
    
    // Chart Items
    var seventyCl = PieChartDataEntry(value: 0)
    var thirtyFiveCl = PieChartDataEntry(value: 0)
    var glass = PieChartDataEntry(value: 0)
    var smoke = PieChartDataEntry(value: 0)
    var studentTicket = PieChartDataEntry(value: 0)
    var adultTicket = PieChartDataEntry(value: 0)
    var confetti = PieChartDataEntry(value: 0)
    
    var numberOfDownloadsDataEntries = [PieChartDataEntry]()
   
    // BarChart Items
    var months: [String]!
    var montlyEndorsement: [Double]!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Draw PieChart
        setItemsForPieChart()
        updateChartData()
        
        //Draw BarChart
        setItemsForBarChart()
        setChart(dataPoints: months, values: montlyEndorsement)
    }
    
    /* PIE CHART */
    // Set item values for first run
    func setItemsForPieChart(){
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
    
    // Update PieChart Data
    func updateChartData() {
        let chartDataSet = PieChartDataSet(values: numberOfDownloadsDataEntries, label: nil)
        let chartData = PieChartData(dataSet: chartDataSet)
        
        let colors = [UIColor(named:"seventyCl"), UIColor(named:"thirtyFiveCl"), UIColor(named:"glass"), UIColor(named:"smoke"), UIColor(named:"studentTicket"), UIColor(named:"adultTicket"), UIColor(named:"confetti")]
        chartDataSet.colors = colors as! [NSUIColor]//ChartColorTemplates.pastel()
        
        pieChart.data = chartData
        
        // visual details
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
    
    /* BAR CHART */
    func setItemsForBarChart(){
        months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"]
        montlyEndorsement = [20.0, 4.0, 6.0, 3.0, 12.0, 16.0, 4.0, 18.0, 2.0, 4.0, 5.0, 4.0]
    }
    
    func setChart(dataPoints: [String], values: [Double]) {
        barChart.noDataText = "You need to provide data for the chart."
        
        var dataEntries: [BarChartDataEntry] = []
        var counter = 0.0
        
        for i in 0..<dataPoints.count {
            counter += 1.0
            let dataEntry = BarChartDataEntry(x: counter, y:values[i])
            dataEntries.append(dataEntry)
        }
        
        let chartDataSet = BarChartDataSet(values: dataEntries, label: "Monthly Endorsement")
        let chartData = BarChartData(dataSet: chartDataSet)
        barChart.data = chartData
        
        // visual details
        // visual details
        chartDataSet.colors = ChartColorTemplates.colorful()
        barChart.noDataText = "No date to display"
        barChart.chartDescription?.text = ""
        barChart.fitScreen()
        barChart.xAxis.labelPosition = .bottom
        barChart.xAxis.setLabelCount(12, force: false)
        barChart.scaleYEnabled = false
        barChart.scaleXEnabled = false
        barChart.pinchZoomEnabled = false
        barChart.doubleTapToZoomEnabled = false
        barChart.highlighter = nil
        barChart.rightAxis.enabled = false
        barChart.xAxis.drawGridLinesEnabled = false
        barChart.backgroundColor = UIColor(named:"pieChartBackground")
        barChart.animate(xAxisDuration: 2.0, yAxisDuration: 2.0)
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

}
