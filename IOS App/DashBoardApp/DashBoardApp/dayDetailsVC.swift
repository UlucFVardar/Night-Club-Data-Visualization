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
    
   
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

}
