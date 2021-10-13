import { version } from "../../package.json";
import { Router } from "express";
import calculateBenefit from "./calculateBenefit";
import getDependentEligibilityForBenefit from "./getDependentEligibilityForBenefit";
import calculateRevisedPension from "./calculateRevisedPension";


export default () => {
  let api = Router();

  api.use("/pension-calculator/v1", calculateBenefit());    
  api.use("/pension-calculator/v1", getDependentEligibilityForBenefit()); 
  api.use("/pension-calculator/v1", calculateRevisedPension()); 
  // perhaps expose some API metadata at the root
  api.get("/", (req, res) => {
    res.json({ version });
  });

  return api;
};
