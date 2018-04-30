//
//  customCell.swift
//  DashBoardApp
//
//  Created by Ilkay Tevfik Devran on 30.04.2018.
//  Copyright © 2018 ilkay_Devran. All rights reserved.
//

import UIKit
import Charts

class customCell: UITableViewCell {

    @IBOutlet weak var dateLabel: UILabel!
    @IBOutlet weak var pieChart: PieChartView!
    @IBOutlet weak var commentText: UITextView!
    
    var iosDataEntry = PieChartDataEntry(value: 0)
    var macDataEntry = PieChartDataEntry(value: 0)
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
