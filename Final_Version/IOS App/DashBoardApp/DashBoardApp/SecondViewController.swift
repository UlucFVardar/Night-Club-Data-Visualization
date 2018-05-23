//
//  SecondViewController.swift
//  DashBoardApp
//
//  Created by Ilkay Tevfik Devran on 30.04.2018.
//  Copyright © 2018 ilkay_Devran. All rights reserved.
//

import UIKit

class SecondViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {

    @IBOutlet weak var tableView: UITableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        tableView.delegate = self
        tableView.dataSource = self
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 10
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "Cell", for: indexPath) as! customCell
        return cell
    }
    
    //set the event that is gonna be realized when a row is selected by user
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        //selectedPhoto = titleArray[indexPath.row]
        performSegue(withIdentifier: "toDetails", sender: nil)
    }
    
    //The way how to transfer data by segue
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "toDetails"{
            let destinationVC = segue.destination as! dayDetailsVC
            //destinationVC.
        }
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

