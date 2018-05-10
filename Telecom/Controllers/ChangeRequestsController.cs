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
    public class ChangeRequestsController : Controller
    {
        private TelecomDb db = new TelecomDb();

        // GET: ChangeRequests
        public ActionResult Index()
        {
            return View(db.ChangeRequests.ToList());
        }

        // GET: ChangeRequests/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            ChangeRequest changeRequest = db.ChangeRequests.Find(id);
            if (changeRequest == null)
            {
                return HttpNotFound();
            }
            return View(changeRequest);
        }

        // GET: ChangeRequests/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: ChangeRequests/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "Id,ChangeDate")] ChangeRequest changeRequest)
        {
            if (ModelState.IsValid)
            {
                db.ChangeRequests.Add(changeRequest);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(changeRequest);
        }

        // GET: ChangeRequests/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            ChangeRequest changeRequest = db.ChangeRequests.Find(id);
            if (changeRequest == null)
            {
                return HttpNotFound();
            }
            return View(changeRequest);
        }

        // POST: ChangeRequests/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "Id,ChangeDate")] ChangeRequest changeRequest)
        {
            if (ModelState.IsValid)
            {
                db.Entry(changeRequest).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(changeRequest);
        }

        // GET: ChangeRequests/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            ChangeRequest changeRequest = db.ChangeRequests.Find(id);
            if (changeRequest == null)
            {
                return HttpNotFound();
            }
            return View(changeRequest);
        }

        // POST: ChangeRequests/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            ChangeRequest changeRequest = db.ChangeRequests.Find(id);
            db.ChangeRequests.Remove(changeRequest);
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
