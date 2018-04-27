using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using Telecom.Models;

namespace Telecom.Controllers
{
    public class ProblemClosuresController : Controller
    {
        private TelecomDb db = new TelecomDb();

        // GET: ProblemClosures
        public ActionResult Index()
        {
            return View(db.ProblemClosures.ToList());
        }

        // GET: ProblemClosures/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            ProblemClosure problemClosure = db.ProblemClosures.Find(id);
            if (problemClosure == null)
            {
                return HttpNotFound();
            }
            return View(problemClosure);
        }

        // GET: ProblemClosures/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: ProblemClosures/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "Id,DateClosed,Solved,Solution")] ProblemClosure problemClosure)
        {
            if (ModelState.IsValid)
            {
                db.ProblemClosures.Add(problemClosure);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(problemClosure);
        }

        // GET: ProblemClosures/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            ProblemClosure problemClosure = db.ProblemClosures.Find(id);
            if (problemClosure == null)
            {
                return HttpNotFound();
            }
            return View(problemClosure);
        }

        // POST: ProblemClosures/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "Id,DateClosed,Solved,Solution")] ProblemClosure problemClosure)
        {
            if (ModelState.IsValid)
            {
                db.Entry(problemClosure).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(problemClosure);
        }

        // GET: ProblemClosures/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            ProblemClosure problemClosure = db.ProblemClosures.Find(id);
            if (problemClosure == null)
            {
                return HttpNotFound();
            }
            return View(problemClosure);
        }

        // POST: ProblemClosures/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            ProblemClosure problemClosure = db.ProblemClosures.Find(id);
            db.ProblemClosures.Remove(problemClosure);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
